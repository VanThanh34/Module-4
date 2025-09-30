package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IBlogService extends IService<Blog> {
    Page<Blog> findAllPageable(int page);

    List<Blog> findByCategoryId(Integer id);
}
