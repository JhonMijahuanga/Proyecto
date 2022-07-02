package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Repositorio de transacciones.
 */
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
