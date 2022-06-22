package com.nttdata.bank.service;

import com.nttdata.bank.model.bean.Staff;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StaffService {

    Flux<Staff> getAll();

    Mono<Staff> save(Staff staff);

    //Mono<Staff> update(Mono<Staff> staffMono, String id);

    Mono<Staff> updateStaff(String id, Staff staff);

    Mono<Void> deleteStaff(String id);
}
