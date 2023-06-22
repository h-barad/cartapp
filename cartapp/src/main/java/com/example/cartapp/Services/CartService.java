package com.example.cartapp.Services;


import com.example.cartapp.Models.Beans.AddToCartBean;
import com.example.cartapp.Models.Beans.AddressBean;
import com.example.cartapp.Models.Beans.CustomerBean;
import com.example.cartapp.Models.Beans.ProductBean;
import com.example.cartapp.Models.CustomResponse;
import com.example.cartapp.Models.Enities.*;
import com.example.cartapp.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CartItemsRepository cartItemsRepository;

    @Autowired
    AddressRepository addressRepository;
    public CustomResponse addToCart(AddToCartBean addToCartBean)
    {
        CustomResponse response=new CustomResponse();
        Cart cart=cartRepository.findCartByCustomerId(addToCartBean.getCustomerId());
        Product product=productRepository.getReferenceById(addToCartBean.getProductId());
        CartItem existingCartItem=cartItemsRepository.findExistingCartItem(addToCartBean.getProductId(), cart.getId());
        if(existingCartItem!=null)
        {
            existingCartItem.setQuantity(existingCartItem.getQuantity()+addToCartBean.getQuantity());
        }
        else {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(addToCartBean.getQuantity());
            double subTotal = cartItem.getQuantity()*product.getPrice();
            cartItem.setSubTotal(subTotal);
            cartItemsRepository.save(cartItem);
        }
        response.setSuccess(true);
        return response;
    }

    public CustomResponse addCustomer(CustomerBean customerBean)
    {
        CustomResponse customResponse=new CustomResponse();
        Customer customer=new Customer();
        customer.setName(customerBean.getName());
        customerRepository.save(customer);
        Cart cart=new Cart();
        cart.setCustomer(customer);
        cart.setCheckedOut(false);
        cartRepository.save(cart);
        customResponse.setSuccess(true);
        return customResponse;
    }

    public CustomResponse addAddress(AddressBean addressBean)
    {
        CustomResponse customResponse=new CustomResponse();
        Customer customer=customerRepository.getReferenceById(addressBean.getCustomerId());
        Address address=new Address();
        address.setCustomer(customer);
        address.setAddress(addressBean.getAddress());
        addressRepository.save(address);
        customResponse.setSuccess(true);
        return customResponse;
    }

    public CustomResponse addProduct(ProductBean productBean)
    {
        CustomResponse customResponse=new CustomResponse();
        Product product=new Product();
        product.setName(productBean.getName());
        product.setPrice(productBean.getPrice());
        productRepository.save(product);
        customResponse.setSuccess(true);
        return customResponse;
    }


}
