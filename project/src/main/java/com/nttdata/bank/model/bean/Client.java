package com.nttdata.bank.model.bean;

import com.nttdata.bank.model.enums.TypeClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase cliente.
 */
@Document(collection = "clients")
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

  @Id
  private String id;
  private String idCompany;
  private String idStaff;
  private TypeClient typeClient;
}
