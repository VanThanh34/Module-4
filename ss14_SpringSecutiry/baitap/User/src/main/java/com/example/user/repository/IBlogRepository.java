package com.example.user.repository;


import com.example.user.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByCategoryId(Integer id);

    Page<Blog> findByDescriptionContainingIgnoreCase(String keyword, Pageable pageable);
}
