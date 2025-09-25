package com.example.bai1.repository;

import com.example.bai1.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IBorrowRepository extends JpaRepository<Borrow, Integer> {
    Optional<Borrow> findByBorrowCode(Long borrowCode);
}

