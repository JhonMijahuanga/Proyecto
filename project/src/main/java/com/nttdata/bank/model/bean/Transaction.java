package com.nttdata.bank.model.bean;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Clase de transacciones.
 */
@Document(collection = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

  @Id
  private String id;
  private String idPassive;
  private String typeTransaction; //DEPOSIT , WITHDRAWAL
  private double amount;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date createdDate = new Date();
}
