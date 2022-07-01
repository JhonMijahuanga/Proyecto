package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Client;
import com.nttdata.bank.model.bean.Staff;
import com.nttdata.bank.model.repository.ClientRepository;
import com.nttdata.bank.model.repository.StaffRepository;
import com.nttdata.bank.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger log= LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Flux<Client> getAll() {

        return clientRepository.findAll();
        /*List<Staff> staff = new ArrayList<>();
        staff= (List<Staff>) clientRepository.findAll().collectList();
        List<Staff> finalStaff = staff;
        Mono.just(staff).doOnNext(string -> {
             if (string.equals("STAFF"))
                 Mono<List<Client>> staff1 = new Mono<List<Client>>;
                    finalStaff.set(string);
         })
                .block();*/
        //return clientRepository.findAll().collectList().flux().fromIterable()
    }
    @Override
    public Mono<Client> save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> updateClient(String id, Client client) {
        return clientRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("CLIENT_NOT_FOUND")))
                .map(p -> {
                    client.setId(id);
                    if (client.getIdCompany() != null)
                        client.setIdCompany(client.getIdCompany());
                    if (client.getIdStaff() != null) client.setIdStaff(client.getIdStaff());
                    return client;
                })
                .flatMap(clientRepository::save);
    }

    @Override
    public Mono<Void> deleteClient(String id) {
        return clientRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new Exception("NOT_FOUND_CLIENT")));
    }

    @Override
    public Mono<Client> findById(String id) {

        return clientRepository.findById(id);
    }
}
