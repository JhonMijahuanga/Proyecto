package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Passive;
import com.nttdata.bank.model.repository.PassiveRepository;
import com.nttdata.bank.service.PassiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PassiveServiceImpl implements PassiveService {

    @Autowired
    private PassiveRepository passiveRepository;

    @Override
    public Flux<Passive> getAllPassive() {
        return passiveRepository.findAll();
    }

    @Override
    public Mono<Passive> savePassive(Passive passive) {
        return passiveRepository.save(passive);
    }
}
