package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Repositorio de tarjeta.
 */
public interface CardRepository extends ReactiveMongoRepository<Card, String> {
}
