package com.example.cartapp.Repositories;

import com.example.cartapp.Models.Enities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

    String sql="select * from cart c where c.customer_id=:customer_id and c.checked_out=false limit 1";
    @Query(nativeQuery = true,value=sql)
    Cart findCartByCustomerId(@Param("customer_id")int customerId);
}
