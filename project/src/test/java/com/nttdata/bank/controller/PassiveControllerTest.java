package com.nttdata.bank.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PassiveControllerTest {

  @Autowired
  WebTestClient webTestClient;

  @Test
  void testGetPassiveAll(){
    webTestClient.get()
        .uri("/api/v1/passives/")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .consumeWith(p ->
            Assertions.assertNotNull(p.getResponseBody()))
        ;
  }
  @Test
  void testPassiveId(){
    webTestClient.get()
        .uri("/api/v1/passives/{id}", "62be1a30a8715725606ddc60")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .consumeWith(p ->
            Assertions.assertNotNull(p.getResponseBody()))
        .jsonPath("$.availableBalance").isEqualTo(500)
    ;
  }

  @Test
  void testRegisterPassive(){
    webTestClient.post()
        .uri("/api/v1/passives")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .syncBody("{\"id\":\"John\"}")
        .exchange()
        .expectStatus().isCreated()
        .expectBody().isEmpty();

  }
}
