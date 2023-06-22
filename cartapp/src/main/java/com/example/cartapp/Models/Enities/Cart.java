package com.example.cartapp.Models.Enities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    boolean checkedOut;

//    @OneToMany(mappedBy = "cart")
//    List<CartItems> cartItemsList;

    @OneToOne
    Customer customer;

    public Cart() {

    }
}
