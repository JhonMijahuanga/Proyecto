package com.nttdata.bank.model.bean;

import com.nttdata.bank.model.enums.TypeCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "creditCards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    private String id;
    private String numberCard;
    private double lineCredit; //linea de credito
    private double availableBalance; //saldo disponible
    private double consumed; //consumido
    private TypeCard typeCard;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate = new Date();
}
