package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    Page<Blog> findAllPageable(int page);

    List<Blog> findByCategoryId(Integer id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByDescriptionContainingIgnoreCase(String keyword, Pageable pageable);
}
