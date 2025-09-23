package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    List<T> findAll();

    void save(T t);

    Optional<T> findById(Integer id);

    void update(T t);

    void deleteById(Integer id);
}
