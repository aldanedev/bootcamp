package com.accountbank.controller;

import com.accountbank.model.Client;
import com.accountbank.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {
    private static final Logger logger = LogManager.getLogger(ClientController.class);
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        return new ResponseEntity<>(clientService.getClients(), HttpStatus.OK);
    }

    @GetMapping("{ruc_dni}")
    public ResponseEntity<Client> getById(@PathVariable Integer ruc_dni){
        logger.info("RUC_DNI: " + ruc_dni);
        if(clientService.getById(ruc_dni).isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(clientService.getById(ruc_dni), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Client> create (@RequestBody Client client){
        logger.info("Create User: " + client);
        return new ResponseEntity(clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("{ruc_dni}")
    public ResponseEntity<Client> update(@PathVariable Integer ruc_dni, @RequestBody Client client){
        logger.info("Cliente a editar: " + clientService.getById(ruc_dni));
        if(clientService.getById(ruc_dni).isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(clientService.update(client), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("{ruc_dni}")
    public ResponseEntity<Void> delete(@PathVariable Integer ruc_dni){
        if(clientService.getById(ruc_dni).isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            clientService.delete(ruc_dni);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
