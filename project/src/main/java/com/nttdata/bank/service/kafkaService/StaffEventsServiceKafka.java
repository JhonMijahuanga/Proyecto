package com.nttdata.bank.service.kafkaService;

import com.nttdata.bank.events.Event;
import com.nttdata.bank.events.StaffCreatedEvent;
import com.nttdata.bank.model.bean.Staff;
import com.nttdata.bank.model.enums.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class StaffEventsServiceKafka {

  @Autowired
  private KafkaTemplate<String, Event<?>> producer;

  @Value("${topic.staff.name:staffs}") //"${topic.customer.name:customers}"
  private String topicStaff;

  public void publish(Staff staff){
    log.info("SERVICIOKAFKA.PUBLISH");
    StaffCreatedEvent createdEvent = new StaffCreatedEvent();
    createdEvent.setData(staff);
    createdEvent.setId(UUID.randomUUID().toString());
    createdEvent.setType(EventType.CREATED);
    createdEvent.setDate(new Date());
    log.info("SE CREO LAS VARIABLES SERVICIOKAFKA.PUBLISH");
    this.producer.send(topicStaff, createdEvent);
    log.info("SE ENVIO A TOPIC - SERVICIOKAFKA.PUBLISH");

  }
}
