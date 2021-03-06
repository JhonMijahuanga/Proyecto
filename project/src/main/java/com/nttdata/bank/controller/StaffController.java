package com.nttdata.bank.controller;

import com.nttdata.bank.model.bean.Staff;
import com.nttdata.bank.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 * Controlador de personal.
 */
@RestController
@RequestMapping("/api/v1/staffs")
@Slf4j
public class StaffController {

  @Autowired
  private StaffService staffService;

  @PostMapping
  public Mono<Staff> register(@RequestBody Staff staff) {
    log.info("staff: " + staff);
    return staffService.save(staff);
  }

  @GetMapping
  public Flux<Staff> getAllStaff() {
    return staffService.getAll();
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Mono<Staff> updateStaff(@PathVariable("id") String id, @RequestBody Staff staff) {
    return staffService.updateStaff(id, staff);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteStaff(@PathVariable("id") String id) {
    staffService.deleteStaff(id).subscribe();
  }



}
