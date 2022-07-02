package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Transaction;
import com.nttdata.bank.model.repository.TransactionRepository;
import com.nttdata.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementacion del servicio de transacciones.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  @Override
  public Mono<Transaction> saveTransaction(Transaction transaction) {
    return transactionRepository.save(transaction);
  }

  @Override
  public Flux<Transaction> getAllTransaction() {

    return transactionRepository.findAll();
  }

}
