package com.example.bai1.service;

import com.example.bai1.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();
    void save(Book book);
    Optional<Book> findById(Integer id);
    long updateBook(Book book);
}
