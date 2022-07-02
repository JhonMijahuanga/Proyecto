package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Staff;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de personal.
 */
@Repository
public interface StaffRepository extends ReactiveMongoRepository<Staff, String> {
}
