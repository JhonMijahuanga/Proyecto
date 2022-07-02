package com.nttdata.bank.controller;

import com.nttdata.bank.model.bean.Client;
import com.nttdata.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador de la clase cliente.
 */
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @PostMapping
  public Mono<Client> register(@RequestBody Client client) {

    return clientService.save(client);
  }

  @GetMapping
  public Flux<Client> getAllClients() {
    return clientService.getAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Client> updateClient(@PathVariable("id") String id, @RequestBody Client client) {
    return clientService.updateClient(id, client);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteClient(@PathVariable("id") String id) {

    clientService.deleteClient(id).subscribe();
  }

}
