package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Passive;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PassiveRepository extends ReactiveMongoRepository<Passive, String> {
}
