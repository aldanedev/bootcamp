package com.nttdata.credits.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.credits.model.Client;

@FeignClient(url = "http://localhost:3000/api/v1/clients/", name = "clients")
public interface ClientClient {
  @GetMapping("{ruc_dni}")
  public ResponseEntity<Client> getById(@PathVariable Long ruc_dni);
}
