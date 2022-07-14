package com.nttdata.bank.events;

import com.nttdata.bank.model.bean.Staff;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StaffCreatedEvent extends Event<Staff> {
}
