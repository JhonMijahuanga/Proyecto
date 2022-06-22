package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Asset;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AssetRepository extends ReactiveMongoRepository<Asset, String>{

}
