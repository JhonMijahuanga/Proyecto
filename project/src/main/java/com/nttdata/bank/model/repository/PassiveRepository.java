package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Passive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Repositorio pasivo.
 */
public interface PassiveRepository extends ReactiveMongoRepository<Passive, String> {

  Mono<Passive> findByTypeAccount(String s);

}
