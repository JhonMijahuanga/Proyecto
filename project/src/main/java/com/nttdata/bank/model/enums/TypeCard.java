package com.nttdata.bank.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Clase enum de tipo de tarjeta.
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum TypeCard {

  DEBIT("DEBIT"), CREDIT("CREDIT");
  private String name;
}
