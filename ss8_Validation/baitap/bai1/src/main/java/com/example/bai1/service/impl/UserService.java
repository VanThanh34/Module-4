package com.example.bai1.service.impl;

import com.example.bai1.entity.User;
import com.example.bai1.repository.IUserRepository;
import com.example.bai1.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository repository;

    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findALl() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
