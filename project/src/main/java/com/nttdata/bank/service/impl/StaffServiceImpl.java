package com.nttdata.bank.service.impl;

import com.nttdata.bank.model.bean.Staff;
import com.nttdata.bank.model.repository.StaffRepository;
import com.nttdata.bank.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Flux<Staff> getAll() {

        return staffRepository.findAll();
    }

    @Override
    public Mono<Staff> save(Staff staff) {
        log.info("StaffServiceimpl"+ staff);
        return staffRepository.save(staff);
    }

    @Override
    public Mono<Staff> updateStaff(String id, Staff staff) {

        return staffRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("STAFF_NOT_FOUND")))
                .map(b -> {
                    staff.setId(id);
                    if (staff.getName() != null) staff.setName(staff.getName());
                    if (staff.getLastName() != null) staff.setLastName(staff.getLastName());
                    if (staff.getDni() != null) staff.setDni(staff.getDni());
                    return staff;
                })
                .flatMap(staffRepository::save);
    }

    @Override
    public Mono<Void> deleteStaff(String id) {
        return staffRepository.deleteById(id);
    }
}
