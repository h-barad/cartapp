package com.example.cartapp.Models.Beans;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class CustomerBean {

    String name;

    public CustomerBean(@JsonProperty("name")String name){
        setName(name);
    }
}
