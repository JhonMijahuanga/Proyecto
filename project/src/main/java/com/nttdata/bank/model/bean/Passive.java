package com.nttdata.bank.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "passives")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passive {

    @Id
    private String id;
    private String idClient;
    private String typeAccount; //Ahorro, Cuenta corriente, Plazo fijo
    private double commission; //comision
    private double availableBalance; //Saldo disponible
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate = new Date();

}
