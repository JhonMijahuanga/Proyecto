package com.nttdata.bank.model.bean;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection="staffs")
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
