package com.nttdata.bank.model.repository;

import com.nttdata.bank.model.bean.Staff;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends ReactiveMongoRepository<Staff, String> {
}
