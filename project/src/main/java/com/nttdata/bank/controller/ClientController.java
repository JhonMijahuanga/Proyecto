package com.nttdata.bank.controller;

import com.nttdata.bank.model.bean.Client;
import com.nttdata.bank.model.bean.Staff;
import com.nttdata.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Mono<Client> register(@RequestBody Client client){

        return clientService.save(client);
    }

    @GetMapping
    public Flux<Client> getAllClients(){
        return clientService.getAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Client> updateClient(@PathVariable("id") String id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable("id") String id) {

        clientService.deleteClient(id).subscribe();
    }

}
