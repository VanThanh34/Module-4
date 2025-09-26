package com.example.bai1.service.impl;

import com.example.bai1.entity.Book;
import com.example.bai1.entity.Borrow;
import com.example.bai1.repository.IBookRepository;
import com.example.bai1.repository.IBorrowRepository;
import com.example.bai1.service.IBookService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookService implements IBookService {
    private final IBookRepository repository;
    private final IBorrowRepository borrowRepository;

    public BookService(IBookRepository repository, IBorrowRepository borrowRepository) {
        this.repository = repository;
        this.borrowRepository = borrowRepository;
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

    public long updateBook(Book book){
        book.setQuantity(book.getQuantity() - 1);
        repository.save(book);


        long code = Long.parseLong(String.format("%05d", (long)(Math.random() * 100000)));


        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setBorrowCode(code);
        borrowRepository.save(borrow);
        return code;
    }
}
