package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;

public interface IBlogService extends IService<Blog> {
    Page<Blog> findAllPageable(int page);
}
