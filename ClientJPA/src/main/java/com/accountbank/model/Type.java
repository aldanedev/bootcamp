package com.accountbank.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idType;

    @Column(name = "description", nullable = false, length = 255)
    private String description;
}
