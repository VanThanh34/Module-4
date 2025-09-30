package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {

    private final IBlogService service;
    private final ICategoryService categoryService;

    public BlogRestController(IBlogService service, ICategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }

    @GetMapping
    public Page<Blog> findAll(@RequestParam(name = "page", defaultValue = "0") int page) {
        return service.findAllPageable(page); // trả JSON
    }

    @GetMapping("/{id}")
    public Blog findById(@PathVariable Integer id) {
        return service.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Không tìm thấy blog với ID: " + id));
    }

    @GetMapping("/category")
    public List<Category> findAllCategory(){
        return categoryService.findAllCategory();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @GetMapping("/category/{id}")
    public List<Blog> findBlogByCategory(@PathVariable Integer id){
        return service.findByCategoryId(id);
    }
}
