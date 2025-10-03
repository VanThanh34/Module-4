package com.example.user.repository;


import com.example.user.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUserName(String username);
}
