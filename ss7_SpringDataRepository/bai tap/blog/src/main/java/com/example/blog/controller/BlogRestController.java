package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Page<Blog>> findAll(@RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Blog> blogs = service.findAllPageable(page);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK); // 200
    }


    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Integer id) {
        Blog blog = service.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Không tìm thấy blog với ID: " + id));
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }


    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categories = categoryService.findAllCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(categories, HttpStatus.OK); // 200
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> findBlogByCategory(@PathVariable Integer id) {
        List<Blog> blogs = service.findByCategoryId(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
