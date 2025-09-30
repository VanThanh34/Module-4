package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.exception.ProductNotFoundException;
import com.example.shoppingcart.repository.IProductRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductRepository productRepository;


    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "view/shop";
    }
    @GetMapping("/map")
    public String showMap() {
        return "view/map"; // trỏ đến map.html
    }
}
