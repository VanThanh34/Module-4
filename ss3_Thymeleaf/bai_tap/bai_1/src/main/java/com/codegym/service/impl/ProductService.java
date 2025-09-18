package com.codegym.service.impl;

import com.codegym.entity.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Product findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void update(Product t) {
        Product productUpdate = repository.findById(t.getId());
        if (productUpdate != null) {
            productUpdate.setName(t.getName());
            productUpdate.setPrice(t.getPrice());
            productUpdate.setDescription(t.getDescription());
            productUpdate.setNhacc(t.getNhacc());
        }
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}

