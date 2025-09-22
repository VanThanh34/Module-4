package com.codegym.c0525g1_spring_boot.service;

import java.util.List;

public interface IService<T> {

    List<T> findAll();

    void save(T t);

    T findById(Integer id);
}
