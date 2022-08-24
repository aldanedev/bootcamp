package com.webflux.jfgb.webflux.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
public class BankAccount {
    @Id
    private String id;
    private String description;
    @Indexed(unique = true)
    private String number;
    private Double limitAccount;
    private String customerId;
}