package com.nttdata.bank.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase compañia.
 */
@Builder
@Document(collection = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

  @Id
  private String id;
  private String[] signers;
  private String nameCompany;
  private String ruc;

}
