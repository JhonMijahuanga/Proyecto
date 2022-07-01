package com.nttdata.bank.service;

import com.nttdata.bank.model.bean.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ClientService {

    Flux<Client> getAll();

    Mono<Client> save(Client client);

    Mono<Client> updateClient(String id, Client client);

    Mono<Void> deleteClient(String id);

    Mono<Client> findById(String s);
}
