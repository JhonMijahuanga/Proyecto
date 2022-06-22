package com.nttdata.bank.service;

import com.nttdata.bank.model.bean.Company;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyService {

    Flux<Company> getAll();

    Mono<Company> save(Company company);

    Mono<Company> updateCompany(String id, Company company);

    Mono<Void> deleteCompany(String id);
}
