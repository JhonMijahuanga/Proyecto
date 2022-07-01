package com.nttdata.bank.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum TypeClient {

    STAFF("STAFF"), COMPANY("COMPANY");
    private String name;
}
