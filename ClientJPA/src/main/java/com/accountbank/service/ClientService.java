package com.accountbank.service;

import com.accountbank.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getClients();
    List<Client> getById(Integer ruc_dni);
    List<Client> create(Client client);
    List<Client> update(Client client);
    void delete(Integer ruc_dni);
}