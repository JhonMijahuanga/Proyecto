package com.nttdata.bank.controller;

import com.nttdata.bank.exception.MyException;
import com.nttdata.bank.model.bean.Transaction;
import com.nttdata.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador de las transacciones.
 */
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

  @Autowired
  private TransactionService transactionService;

  /**
   * Method Register Movement.
   *
   * @param transaction *
   * @return transaction
   */
  @PostMapping
  public Mono<Transaction> registerTransaction(@RequestBody Transaction transaction) {
    if (transaction.getIdPassive() == null || transaction.getIdPassive().isEmpty()) {
      throw new MyException(HttpStatus.BAD_REQUEST, "INVALID idPassive");
    } else {
      return transactionService.saveTransaction(transaction);
    }
  }

  @GetMapping
  public Flux<Transaction> getAllTransaction() {

    return transactionService.getAllTransaction();
  }


}
