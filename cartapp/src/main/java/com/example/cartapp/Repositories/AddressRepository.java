package com.example.cartapp.Repositories;

import com.example.cartapp.Models.Enities.Address;
import com.example.cartapp.Models.Enities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {


}
