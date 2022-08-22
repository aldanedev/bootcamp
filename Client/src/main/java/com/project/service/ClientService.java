package com.project.service;

import com.project.model.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
	Flux<Client> getClients();

	Mono<Client> getById(String id);

	Mono<Client> create(Client client);

	Mono<Client> edit(String id, Client client);

	Mono<Void> delete(Client client);
}
