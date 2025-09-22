package com.example.demo.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    void save(T t);

    T findById(Integer id);

    void update(T t);

    void deleteById(Integer id);
}
