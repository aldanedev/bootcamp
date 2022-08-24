package com.nttdata.credits.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "credit_cards")
public class CreditCard {
    @Id
    private String id;
    private String description;
    @Indexed(unique = true)
    private String number;
    private Double limitCredit;
    private String customerId;
}
