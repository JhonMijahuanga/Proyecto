package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Company;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio compañia.
 */
@Repository
public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

}
