package com.example.demo.service.impl;


import com.example.demo.entity.Product;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void update(Product p) {
        Optional<Product> productUpdate = repository.findById(p.getId());
        if (productUpdate.isPresent()) {
            Product product = productUpdate.get();
            product.setName(p.getName());
            product.setPrice(p.getPrice());
            product.setDescription(p.getDescription());
            product.setNhacc(p.getNhacc());

            repository.save(product);
        }
    }


    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}

