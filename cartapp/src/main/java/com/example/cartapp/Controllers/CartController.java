package com.example.cartapp.Controllers;

import com.example.cartapp.Models.Beans.*;
import com.example.cartapp.Models.CustomResponse;
import com.example.cartapp.Models.Enities.Orders;
import com.example.cartapp.Models.Enities.Product;
import com.example.cartapp.Repositories.CustomerRepository;
import com.example.cartapp.Services.CartService;
import com.example.cartapp.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/addToCart")
    CustomResponse addToCart(@RequestBody AddToCartBean addToCartBean)
    {
        return cartService.addToCart(addToCartBean);
    }

    @PostMapping("/addCustomer")
    public CustomResponse addCustomer(@RequestBody CustomerBean customerBean)
    {
        return cartService.addCustomer(customerBean);
    }

    @PostMapping("/addAddress")
    public CustomResponse addAddress(@RequestBody AddressBean addressBean)
    {
        return cartService.addAddress(addressBean);
    }

    @PostMapping("/addProduct")
    public CustomResponse addProduct(@RequestBody ProductBean productBean)
    {
        return cartService.addProduct(productBean);
    }

    @GetMapping("/placeOrder")
    public Orders placeOrder(@RequestBody PlaceOrderBean placeOrderBean)
    {
        return orderService.placeOrder(placeOrderBean);

    }
}
