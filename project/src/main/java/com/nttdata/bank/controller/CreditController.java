package com.nttdata.bank.controller;

import com.nttdata.bank.model.bean.Credit;
import com.nttdata.bank.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping
    public Mono<Credit> registerCredit(@RequestBody Credit credit) {
        return creditService.saveCredit(credit);
    }

    @GetMapping
    public Flux<Credit> getAllCredit(){

        return creditService.getAllCredits();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Credit> updateCredit(@PathVariable("id") String id, @RequestBody Credit credit){

        return creditService.updateCredit(id, credit);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCredit(@PathVariable("id") String id){

        creditService.deleteCredit(id).subscribe();
    }
}
