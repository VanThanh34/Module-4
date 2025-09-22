package com.example.blog.service.impl;

import com.example.blog.entity.Blog;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

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

    @Override
    public void save(Blog blog) {
        repository.save(blog);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void update(Blog b) {
        Optional<Blog> blogUpdate = repository.findById(b.getId());
        if (blogUpdate.isPresent()) {
            Blog blog = blogUpdate.get();
            blog.setDay(b.getDay());
            blog.setDescription(b.getDescription());
            blog.setContext(b.getContext());
            repository.save(blog);
        }
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
