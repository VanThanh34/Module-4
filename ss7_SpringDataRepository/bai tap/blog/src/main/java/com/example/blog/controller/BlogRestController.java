package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.exception.CategoryNotFoundException;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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


    @PostMapping("/create")
    public ResponseEntity<?> addBlog(@Validated @RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        System.out.println("CategoryId nhận được: " + blogDto.getCategoryId());
        Category category = categoryService.findById(blogDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category không tồn tại"));


        blog.setCategory(category);
        service.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable Integer id,
                                    @Validated @RequestBody BlogDto blogDto) {
        Blog existBlog = service.findById(id).orElseThrow(()->
                new BlogNotFoundException("Không tìm thấy blog với id: "+id));
        BeanUtils.copyProperties(blogDto, existBlog, "id");
        Category category = categoryService.findById(blogDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category không tồn tại"));
        existBlog.setCategory(category);
        service.update(existBlog);
        return new ResponseEntity<>(existBlog, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<List<Blog>> findBlogByCategory(@PathVariable Integer id) {
        List<Blog> blogs = service.findByCategoryId(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


}
