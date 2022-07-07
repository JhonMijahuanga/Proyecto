package com.nttdata.bank.controller;

import com.nttdata.bank.model.bean.Passive;
import com.nttdata.bank.service.PassiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador de pasivo.
 */
@RestController
@RequestMapping("/api/v1/passives")
public class PassiveController {

  @Autowired
  private PassiveService passiveService;

  @PostMapping
  public Mono<Passive> registerPassive(@RequestBody Passive passive) {
    return passiveService.savePassive(passive);
  }

  @GetMapping
  public Flux<Passive> getPassives() {
    return passiveService.getAllPassive();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Passive> getPassiveId(@PathVariable("id") String id){
    return passiveService.getPassiveId(id);
  }
}
