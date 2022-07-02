package com.nttdata.bank.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Contiene los atributos de la clase Activos.
 **/

@Document(collection = "assets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asset { //Activos

  @Id
  private String id;
  private String idClient;
  private String idCard;
  private String[] idCredit;
}
