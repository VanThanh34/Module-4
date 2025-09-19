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
