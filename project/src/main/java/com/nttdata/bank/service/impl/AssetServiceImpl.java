package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Asset;
import com.nttdata.bank.model.repository.AssetRepository;
import com.nttdata.bank.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Flux<Asset> getAllAsset() {

        return assetRepository.findAll();
    }

    @Override
    public Mono<Asset> saveAsset(Asset asset) {

        return assetRepository.save(asset);

    }

    @Override
    public Mono<Asset> updateAsset(String id, Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public Mono<Void> deleteAsset(String id) {
        return assetRepository.deleteById(id)
                .switchIfEmpty(Mono.error(new Exception("NOT FOUND ASSET")));
    }
}
