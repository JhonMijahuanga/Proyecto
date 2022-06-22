package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Card;
import com.nttdata.bank.model.repository.CardRepository;
import com.nttdata.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Mono<Card> saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Flux<Card> getAllCard() {
        return cardRepository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Card> updateCard(@PathVariable("id") String id, @RequestBody Card card) {
        return cardRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("CLIENT NOT FOUND")))
                .map(p -> {
                    card.setId(id);
                    if (card.getNumberCard() != null) card.setNumberCard(card.getNumberCard());
                    if (card.getAvailableBalance() >= 0) card.setAvailableBalance(card.getAvailableBalance());
                    if (card.getLineCredit() >= 0) card.setLineCredit(card.getLineCredit());
                    return card;
                })
                .flatMap(cardRepository::save);
    }

    @Override
    public Mono<Void> deleteCard(String id) {
        return cardRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new Exception("NOT_FOUND_CARD")));
    }
}
