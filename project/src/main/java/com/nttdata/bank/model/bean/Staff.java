package com.nttdata.bank.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase staff.
 */
@Builder
@Document(collection = "staffs")
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

  @Id
  private String id;
  private String name;
  private String lastName;
  private String dni;

}
