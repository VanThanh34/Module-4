package com.example.shoppingcart.service.impl;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.repository.IProductRepository;
import com.example.shoppingcart.service.IProductService;

import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }
}
