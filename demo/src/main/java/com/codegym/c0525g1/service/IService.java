package com.codegym.c0525g1.service;

import com.codegym.c0525g1.entity.Student;

import java.util.List;

public interface IService<T> {

    List<T> findAll();

    void save(T t);

    T findById(Integer id);
}
