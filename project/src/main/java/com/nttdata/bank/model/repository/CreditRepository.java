package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {
}
