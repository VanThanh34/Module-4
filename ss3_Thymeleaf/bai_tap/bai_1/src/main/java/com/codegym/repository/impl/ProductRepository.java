package com.codegym.repository.impl;

import com.codegym.entity.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iPhone 15 Pro", 1200.0, "Flagship Apple 2023", "Apple Store"));
        products.add(new Product(2, "Samsung Galaxy S23", 1000.0, "Flagship Samsung 2023", "Samsung VN"));
        products.add(new Product(3, "MacBook Pro M2", 2500.0, "Laptop hiệu năng cao", "Apple Store"));
        products.add(new Product(4, "Dell XPS 15", 1800.0, "Ultrabook cao cấp", "Dell VN"));
        products.add(new Product(5, "Sony WH-1000XM5", 450.0, "Tai nghe chống ồn", "Sony Center"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        if (products.isEmpty()) {
            product.setId(1);
        } else {
            Integer id = products.get(products.size() - 1).getId() + 1;
            product.setId(id);
        }
        products.add(product);
    }


    @Override
    public Product findById(Integer id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
}
