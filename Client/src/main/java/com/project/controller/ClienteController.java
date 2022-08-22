package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;

import com.project.model.Client;
import com.project.service.ClientService;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/client")
@RestController
public class ClienteController {

	@Autowired
	private ClientService clientService;

	/*
	 * Listar Clientes
	 */
	@GetMapping
	public Mono<ResponseEntity<Flux<Client>>> getClients() {

		return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientService.getClients()));
	}

	/*
	 * Consultar Cliente por 'id'
	 */
	@GetMapping("{id}")
	public Mono<ResponseEntity<Client>> getById(@PathVariable String id) {

		return clientService.getById(id).map(c -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(c))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/*
	 * Crear Cliente
	 */
	@PostMapping
	public Mono<ResponseEntity<Map<String, Object>>> create(@Valid @RequestBody Mono<Client> monoClient) {

		Map<String, Object> respuesta = new HashMap<>();

		return monoClient.flatMap(cliente -> clientService.create(cliente).map(c -> {
			respuesta.put("cliente", c);
			respuesta.put("mensaje", "Cliente guardado con exito!");
			respuesta.put("timestamp", new Date());

			return ResponseEntity.created(URI.create("/api/client/".concat(c.get_id())))
					.contentType(MediaType.APPLICATION_JSON).body(respuesta);
		})).onErrorResume(t -> Mono.just(t).cast(WebExchangeBindException.class)
				.flatMap(e -> Mono.just(e.getFieldErrors())).flatMapMany(Flux::fromIterable)
				.map(fieldError -> "El campo: " + fieldError.getField() + " " + fieldError.getDefaultMessage())
				.collectList().flatMap(list -> {
					respuesta.put("errors", list);
					respuesta.put("timestamp", new Date());
					respuesta.put("status", HttpStatus.BAD_REQUEST.value());

					return Mono.just(ResponseEntity.badRequest().body(respuesta));
				}));
	}

	/*
	 * Editar Cliente
	 */
	@PutMapping("{id}")
	public Mono<ResponseEntity<Client>> edit(@PathVariable String id, @RequestBody Client client) {

		return clientService.getById(id).flatMap(c -> {
			c.setName(client.getName());
			c.setDni_ruc(client.getDni_ruc());
			c.setTypeClient(client.getTypeClient());

			return clientService.create(c);
		}).map(c -> ResponseEntity.created(URI.create("/api/client/".concat(c.get_id())))
				.contentType(MediaType.APPLICATION_JSON).body(c)).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	/*
	 * Eliminar Cliente
	 */
	@DeleteMapping("{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id) {

		return clientService.getById(id)
				.flatMap(c -> clientService.delete(c).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
