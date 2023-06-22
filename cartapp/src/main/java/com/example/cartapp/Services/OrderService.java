package com.example.cartapp.Services;

import com.example.cartapp.Models.Beans.PlaceOrderBean;
import com.example.cartapp.Models.Enities.Address;
import com.example.cartapp.Models.Enities.Cart;
import com.example.cartapp.Models.Enities.CartItem;
import com.example.cartapp.Models.Enities.Orders;
import com.example.cartapp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CartItemsRepository cartItemsRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    public Orders placeOrder(PlaceOrderBean placeOrderBean)
    {
        Cart cart= cartRepository.findCartByCustomerId(placeOrderBean.getCustomerId());
        cart.setCheckedOut(true);
        Address address= addressRepository.findById(placeOrderBean.getAddressId()).orElse(null);
        List<CartItem> cartItemList=cartItemsRepository.findByCartId(cart.getId());
        double total=0;
        for(CartItem cartItem:cartItemList)
        {
            total+=cartItem.getSubTotal();
        }
        Orders order=new Orders();
        order.setCustomer(customerRepository.getReferenceById(placeOrderBean.getCustomerId()));
        order.setCart(cart);
        order.setTotal(total);
        order.setDate(new Date());
        order.setAddress(address);
        orderRepository.save(order);
        return order;
    }
}
