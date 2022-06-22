package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Company;
import com.nttdata.bank.model.repository.CompanyRepository;
import com.nttdata.bank.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Flux<Company> getAll() {

        return companyRepository.findAll();
    }

    @Override
    public Mono<Company> save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Mono<Company> updateCompany(String id, Company company) {
        return companyRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception(("COMPANY_NOT_FOUND"))))
                .map(c -> {
                    company.setId(id);
                    if (company.getSigners() != null) company.setSigners(company.getSigners());
                    if (company.getNameCompany() != null) company.setNameCompany(company.getNameCompany());
                    if (company.getRuc() != null) company.setRuc(company.getRuc());
                    return company;
                })
                .flatMap(companyRepository::save);
    }

    @Override
    public Mono<Void> deleteCompany(String id) {
        return companyRepository.deleteById(id);
    }
}
