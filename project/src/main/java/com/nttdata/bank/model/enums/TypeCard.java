package com.nttdata.bank.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum TypeCard {

    DEBIT("DEBIT"),CREDIT("CREDIT");
    private String name;
}
