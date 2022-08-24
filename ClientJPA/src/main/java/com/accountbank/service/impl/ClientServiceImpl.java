package com.accountbank.service.impl;

import com.accountbank.model.Client;
import com.accountbank.repository.ClientRepository;
import com.accountbank.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private static final Logger logger = LogManager.getLogger(ClientService.class);
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> getById(Integer ruc_dni) {
        logger.info("Usuario encontrado ? " + clientRepository.findById(ruc_dni));
        return clientRepository.findById(ruc_dni).stream().collect(Collectors.toList());
    }

    @Override
    public List<Client> create(Client client) {
        return List.of(clientRepository.save(client));
    }

    @Override
    public List<Client> update(Client client) {
        return List.of(clientRepository.save(client));
    }

    @Override
    public void delete(Integer ruc_dni) {
        clientRepository.deleteById(ruc_dni);
    }
}
