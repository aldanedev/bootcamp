package com.accountbank.service;

import com.accountbank.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getClients();
    List<Client> getById(Long ruc_dni);
    List<Client> create(Client client);
    List<Client> update(Client client);
    void delete(Long ruc_dni);
}