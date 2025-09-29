package com.example.shoppingcart.service;

import com.example.shoppingcart.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Integer id);
}
