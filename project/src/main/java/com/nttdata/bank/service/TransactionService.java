package com.nttdata.bank.service;

import com.nttdata.bank.model.bean.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz del servicio de transacciones.
 */
public interface TransactionService {

  Mono<Transaction> saveTransaction(Transaction transaction);

  Flux<Transaction> getAllTransaction();

  //Mono<Transaction> updateTransaction(String id, Transaction transaction);

}
