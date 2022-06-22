package com.nttdata.bank.controller;

import com.nttdata.bank.model.bean.Asset;
import com.nttdata.bank.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping
    public Mono<Asset> registerAsset(@RequestBody Asset asset){

        return assetService.saveAsset(asset);

    }

    @GetMapping
    public Flux<Asset> getAllAsset(){

        return assetService.getAllAsset();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Asset> updateAsset(@PathVariable("id") String id, @RequestBody Asset asset){

        return assetService.updateAsset(id, asset);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAsset(@PathVariable("id") String id){

        assetService.deleteAsset(id).subscribe();
    }


}
