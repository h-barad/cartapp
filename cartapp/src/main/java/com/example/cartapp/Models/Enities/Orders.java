package com.example.cartapp.Models.Enities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    double total;

    @Column
    Date date;

    @ManyToOne
    Customer customer;

    @OneToOne
    Cart cart;

    @OneToOne
    Address address;

    public Orders(){

    }


}
