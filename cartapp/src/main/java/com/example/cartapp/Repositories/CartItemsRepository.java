package com.example.cartapp.Repositories;

import com.example.cartapp.Models.Enities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CartItemsRepository extends JpaRepository<CartItem,Integer> {

    String sql="select * from cart_item c where c.product_id=:prod_id and c.cart_id =:cart_id limit 1";
    @Query(nativeQuery = true,value = sql)
    CartItem findExistingCartItem(@Param("prod_id")int productId, @Param("cart_id")int cartId);

    String fbc="select * from cart_item c where c.cart_id =:cart_id";
    @Query(nativeQuery = true,value=fbc)
    List<CartItem> findByCartId(@Param("cart_id")int cartId);
}
