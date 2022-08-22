package com.nttdata.credits.domain;

import org.springframework.context.annotation.Description;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "credits")
public class CreditCart {
    @Id    
    private String description;
    private Double limitCredit;  
    private String customerId;  
}
