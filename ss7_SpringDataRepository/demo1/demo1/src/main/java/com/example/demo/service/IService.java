package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> findAll();

    void save(T t);

    Optional<T> findById(Integer id);

    void update(T t);

    void deleteById(Integer id);
}
