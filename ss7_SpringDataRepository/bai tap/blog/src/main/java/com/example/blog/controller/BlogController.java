package com.example.blog.controller;

import com.example.blog.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private final IBlogService service;

    public BlogController(IBlogService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("blogs",service.findAll());
        model.addAttribute("notfound", "Chưa cập nhật Blog nào!");
        return "blog/list";
    }
}
