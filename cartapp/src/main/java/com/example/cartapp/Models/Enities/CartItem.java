package com.example.cartapp.Models.Enities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

@Entity
@Table
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    Product product;

    @Column
    Long quantity;

    @Column
    double subTotal;

    @ManyToOne
    Cart cart;

    public CartItem() {

    }
}
