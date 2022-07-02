package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de cliente.
 */
@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

}
