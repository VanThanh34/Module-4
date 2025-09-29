package com.example.shoppingcart.repository;

import com.example.shoppingcart.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer > {
}
