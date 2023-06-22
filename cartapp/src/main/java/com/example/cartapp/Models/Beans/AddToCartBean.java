package com.example.cartapp.Models.Beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddToCartBean {
    int customerId;int productId;Long quantity;
}
