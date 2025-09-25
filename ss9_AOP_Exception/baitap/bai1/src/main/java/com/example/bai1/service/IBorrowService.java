package com.example.bai1.service;

import com.example.bai1.entity.Borrow;

import java.util.Optional;

public interface IBorrowService {
    void save(Borrow borrow);

    Optional<Borrow> findByBorrowCode(Long code);

    void delete(Borrow borrow);
}
