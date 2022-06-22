package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Transaction;
import com.nttdata.bank.model.repository.TransactionRepository;
import com.nttdata.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    /*@Override
    public Mono<Transaction> updateTransaction(String id, Transaction transaction) {
        return transactionRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("STAFF_NOT_FOUND")))
                .map(b -> {
                    transaction.setId(id);
                    if (transaction.getIdPassive() != null)
                        transaction.setIdPassive(transaction.getIdPassive());
                    if (transaction.getTypeTransaction() != null)
                        transaction.setTypeTransaction(transaction.getTypeTransaction());
                    if (transaction.getAmount() > 0) transaction.setAmount(transaction.getAmount());
                    return transaction;
                })
                .flatMap(transactionRepository::save);
    }*/
}
