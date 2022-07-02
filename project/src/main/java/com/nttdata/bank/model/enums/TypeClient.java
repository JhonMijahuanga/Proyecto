package com.nttdata.bank.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Clase enum de tipo de cliente.
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum TypeClient {

  STAFF("STAFF"), COMPANY("COMPANY");
  private String name;
}
