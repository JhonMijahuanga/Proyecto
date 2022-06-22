package com.nttdata.bank.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="clients")
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    private String id;
    private String idCompany;
    private String idStaff;
}
