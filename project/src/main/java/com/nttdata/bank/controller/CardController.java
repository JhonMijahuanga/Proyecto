package com.nttdata.bank.controller;

import com.nttdata.bank.model.bean.Card;
import com.nttdata.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador de la clase tarjeta.
 */
@RestController
@RequestMapping("/api/v1/cards")
public class CardController {

  @Autowired
  private CardService cardService;

  @PostMapping
  public Mono<Card> registerCreditCard(@RequestBody Card card) {

    return cardService.saveCard(card);
  }

  @GetMapping
  public Flux<Card> getAllCreditCard() {

    return cardService.getAllCard();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Card> updateCard(@PathVariable("id") String id, @RequestBody Card card) {

    return cardService.updateCard(id, card);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteCredit(@PathVariable("id") String id) {

    cardService.deleteCard(id).subscribe();
  }

}
