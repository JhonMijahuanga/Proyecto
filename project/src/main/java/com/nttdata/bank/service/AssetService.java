package com.nttdata.bank.service;

import com.nttdata.bank.model.bean.Asset;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AssetService {

    Flux<Asset> getAllAsset();

    Mono<Asset> saveAsset(Asset asset);

    Mono<Asset> updateAsset(String id, Asset asset);

    Mono<Void> deleteAsset(String id);

}
