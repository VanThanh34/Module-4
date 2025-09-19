package com.codegym.repository.impl;

import com.codegym.entity.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> products = new ArrayList<>();

//    static {
//        products.add(new Product(1, "iPhone 15 Pro", 1200.0, "Flagship Apple 2023", "Apple Store"));
//        products.add(new Product(2, "Samsung Galaxy S23", 1000.0, "Flagship Samsung 2023", "Samsung VN"));
//        products.add(new Product(3, "MacBook Pro M2", 2500.0, "Laptop hiệu năng cao", "Apple Store"));
//        products.add(new Product(4, "Dell XPS 15", 1800.0, null, "Dell VN"));
//        products.add(new Product(5, "Sony WH-1000XM5", 450.0, "Tai nghe chống ồn", "Sony Center"));
//    }

    @Override
    public List<Product> findAll() {
        List<Product> products = BaseRepository.entityManager
                .createQuery("select p from products as p").getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }


    @Override
    public Product findById(Integer id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void update(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();
            BaseRepository.entityManager.merge(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    @Override
    public void deleteById(Integer id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try {
            transaction.begin();

            Product product = BaseRepository.entityManager.find(Product.class, id);
            if (product != null) {
                BaseRepository.entityManager.remove(product);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}
