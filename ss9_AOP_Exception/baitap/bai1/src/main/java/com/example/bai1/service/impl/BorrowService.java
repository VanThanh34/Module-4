package com.example.bai1.service.impl;

import com.example.bai1.entity.Borrow;
import com.example.bai1.repository.IBorrowRepository;
import com.example.bai1.service.IBorrowService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowService implements IBorrowService {
    private final IBorrowRepository repository;

    public BorrowService(IBorrowRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Borrow borrow) {
        repository.save(borrow);
    }

    @Override
    public Optional<Borrow> findByBorrowCode(Long code) {
        return repository.findByBorrowCode(code);
    }

    @Override
    public void delete(Borrow borrow) {
        repository.delete(borrow);
    }
}
