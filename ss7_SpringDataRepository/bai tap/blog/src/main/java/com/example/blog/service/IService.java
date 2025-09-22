package com.example.blog.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
}
