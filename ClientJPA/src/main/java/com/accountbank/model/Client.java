package com.accountbank.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @Column(name = "ruc_dni", nullable = false, unique = true, length = 255)
    private Integer ruc_dni;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "idType")
    private Type types;
}
