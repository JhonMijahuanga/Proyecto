package com.nttdata.bank.controller;

import com.nttdata.bank.model.bean.Company;
import com.nttdata.bank.service.CompanyService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador de la clase compañia.
 */
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

  @Autowired
  private CompanyService companyService;

  @PostMapping
  public Mono<Company> register(@RequestBody Company company) {
    return companyService.save(company);
  }

  @GetMapping
  public Flux<Company> getAllCompany() {
    return companyService.getAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Company> updateCompany(@PathVariable("id") String id, @RequestBody Company company) {
    return companyService.updateCompany(id, company);
  }

  /**
   * Method Register Movement.
   *
   * @param id *
   * @return status Ok
   */
  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  //@ResponseStatus(HttpStatus.OK ="Delete")
  public ResponseEntity<Map<String, String>> deleteCompany(@PathVariable("id") String id) {
    companyService.deleteCompany(id).subscribe();
    try {
      Map<String, String> body = new HashMap<>();
      body.put("message", "SUCCESSFULLY ELIMINATED");
      return new ResponseEntity<>(body, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
