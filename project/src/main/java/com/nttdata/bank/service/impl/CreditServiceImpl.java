package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Credit;
import com.nttdata.bank.model.repository.CreditRepository;
import com.nttdata.bank.service.CreditService;
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
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Mono<Credit> saveCredit(Credit credit) {

        return creditRepository.save(credit);
    }

    @Override
    public Flux<Credit> getAllCredits() {

        return creditRepository.findAll();
    }

    @PutMapping("/{id")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Credit> updateCredit(@PathVariable("id") String id, @RequestBody Credit credit){
        return creditRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("CREDIT NOT FOUND")))
                .map(c -> {
                    credit.setId(id);
                    if (credit.getBalance() >= 0) credit.setBalance(credit.getBalance());
                    if (credit.getCapital() >= 0) credit.setCapital((credit.getCapital()));
                    return credit;
                })
                .flatMap(creditRepository::save);
    }

    @Override
    public Mono<Void> deleteCredit(String id){

        return creditRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new Exception("NOT_FOUND_IDCREDIT")));
    }
}
