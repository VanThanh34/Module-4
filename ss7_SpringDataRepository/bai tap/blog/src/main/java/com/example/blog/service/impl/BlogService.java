package com.example.blog.service.impl;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BlogService implements IBlogService {
    private final IBlogRepository repository;

    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }
}
