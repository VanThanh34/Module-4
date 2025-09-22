package com.example.demo.repository;

import com.codegym.entity.Product;

import java.util.List;

public interface IProductRepository extends  {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Product product);

    void deleteById(Integer id);
}
