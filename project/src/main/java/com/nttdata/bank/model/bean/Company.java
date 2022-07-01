package com.nttdata.bank.model.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection="companies")
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
