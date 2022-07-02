package com.nttdata.bank.service;

import com.nttdata.bank.model.bean.Passive;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase servico de pasivo.
 */
public interface PassiveService {

  Flux<Passive> getAllPassive();

  Mono<Passive> savePassive(Passive passive);

}
