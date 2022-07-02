package com.nttdata.bank.service;

import com.nttdata.bank.model.bean.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de credito servicio.
 */
public interface CreditService {

  Mono<Credit> saveCredit(Credit credit);

  Flux<Credit> getAllCredits();

  Mono<Credit> updateCredit(String id, Credit credit);

  Mono<Void> deleteCredit(String id);


}
