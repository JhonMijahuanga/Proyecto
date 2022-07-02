package com.nttdata.bank.service;

import com.nttdata.bank.model.bean.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servicio de tarjeta.
 */
public interface CardService {

  Mono<Card> saveCard(Card card);

  Flux<Card> getAllCard();

  Mono<Card> updateCard(String id, Card card);

  Mono<Void> deleteCard(String id);

}
