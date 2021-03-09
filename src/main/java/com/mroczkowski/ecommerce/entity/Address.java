package com.mroczkowski.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String state;
    private String country;
    private String ZipCode;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
