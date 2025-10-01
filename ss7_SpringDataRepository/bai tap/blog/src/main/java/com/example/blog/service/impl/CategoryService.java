package com.example.blog.service.impl;


import com.example.blog.entity.Category;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository repository;

    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Category> findAllCategory() {
        return repository.findAll();
    }
}
