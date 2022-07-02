package com.nttdata.bank.service.impl;

import com.nttdata.bank.exception.MyException;
import com.nttdata.bank.model.bean.Passive;
import com.nttdata.bank.model.repository.PassiveRepository;
import com.nttdata.bank.service.ClientService;
import com.nttdata.bank.service.PassiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementacion de servicio pasivo.
 */
@Slf4j
@Service
public class PassiveServiceImpl implements PassiveService {

  @Autowired
  private PassiveRepository passiveRepository;

  @Autowired
  private ClientService clientService;

  @Override
  public Flux<Passive> getAllPassive() {

    return passiveRepository.findAll();
  }

  @Override
  public Mono<Passive> savePassive(Passive passive) {

    Mono<Passive> passiveMono = null;
    if (clientService.findById(passive.getIdClient()).block().getTypeClient().getName()
        .equals("STAFF")) {
      try {
        if (!passiveRepository.findByTypeAccount(passive.getTypeAccount()).block()
            .equals(null)) {
          throw new MyException(HttpStatus.BAD_REQUEST, "COUNT_NOT_FOUND");
        }
      } catch (NullPointerException exception) {
        passiveMono = passiveRepository.save(passive);
        log.info("AGREGADO " + passive.getIdClient());
      }
    }
    if (clientService.findById(passive.getIdClient()).block().getTypeClient().getName()
        .equals("COMPANY")) {
      if (!passive.getTypeAccount().equals("CURRENT")) {
        throw new MyException(HttpStatus.BAD_REQUEST, "SOLO AGREGA CUENTAS CORRIENTES");
      } else {
        log.info("AGREGADO");
        return passiveRepository.save(passive);
      }

    }
    return passiveMono;

  }

}
