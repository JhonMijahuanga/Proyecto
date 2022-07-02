package com.nttdata.bank.model.bean;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Clase credito.
 */
@Document(collection = "credits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credit {

  @Id
  private String id;
  private double balance; //saldo
  private double capital;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date createdDate = new Date();
}
