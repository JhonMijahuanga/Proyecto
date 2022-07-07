package com.nttdata.bank.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PassiveControllerTest {

  @Autowired
  WebTestClient client;

  @Test
  public void testGetPassiveAll(){
    client.get()
        .uri("/api/v1/passives/")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .consumeWith(p ->
            Assertions.assertNotNull(p.getResponseBody()))
        ;
  }
  @Test
  public void testPassiveId(){
    client.get()
        .uri("/api/v1/passives/{id}", "62be1a30a8715725606ddc60")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .consumeWith(p ->
            Assertions.assertNotNull(p.getResponseBody()))
        .jsonPath("$.availableBalance").isEqualTo(500)
    ;
  }
}
