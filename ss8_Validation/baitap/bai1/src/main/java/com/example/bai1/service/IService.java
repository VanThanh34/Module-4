package com.example.bai1.service;

import java.util.List;

public interface IService<T> {
    List<T> findALl();
    void save(T t);
}
