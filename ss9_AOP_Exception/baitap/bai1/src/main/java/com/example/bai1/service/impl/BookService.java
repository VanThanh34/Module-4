package com.example.bai1.service.impl;

import com.example.bai1.entity.Book;
import com.example.bai1.repository.IBookRepository;
import com.example.bai1.service.IBookService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookService implements IBookService {
    private final IBookRepository repository;

    public BookService(IBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return repository.findById(id);
    }
}
