package com.codegym.c0525g1_spring_boot.repository;

import com.codegym.c0525g1_spring_boot.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}