package com.nttdata.bank.service.kafkaService;

import com.nttdata.bank.model.bean.Staff;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StaffServiceKafka {

  /*@Autowired
  private  StaffEventsServiceKafka staffEventsServiceKafka;

  public StaffServiceKafka(StaffEventsServiceKafka staffEventsServiceKafka){
    super();
    this.staffEventsServiceKafka = staffEventsServiceKafka;
  }

  public Staff save(Staff staff){
    System.out.println("Received" + staff);
    log.info("Received");
    this.staffEventsServiceKafka.publish(staff);
    return staff;
  }*/
}
