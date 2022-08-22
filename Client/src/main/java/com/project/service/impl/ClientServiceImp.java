package com.project.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.model.Client;
import com.project.repository.ClientRepository;
import com.project.service.ClientService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImp implements ClientService {

	private ClientRepository clientRepository;

	@Override
	public Flux<Client> getClients() {
		return clientRepository.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<Client> getById(String id) {
		return clientRepository.findById(id);
	}

	@Override
	public Mono<Client> create(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Mono<Client> edit(String id, Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Mono<Void> delete(Client client) {
		return clientRepository.delete(client);
	}

}
