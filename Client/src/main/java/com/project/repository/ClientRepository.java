package com.project.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Client;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

}
