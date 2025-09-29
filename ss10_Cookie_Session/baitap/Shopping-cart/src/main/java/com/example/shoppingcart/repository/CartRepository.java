package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
