package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.Product;
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


    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable("id") Integer id, HttpSession session) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy sản phẩm id=" + id));


        Map<Integer, Integer> cart = Optional.ofNullable(session.getAttribute("cart"))
                .filter(obj -> obj instanceof Map)
                .map(obj -> (Map<Integer, Integer>) obj)
                .orElse(new HashMap<>());



        cart.put(id, cart.getOrDefault(id, 0) + 1);


        session.setAttribute("cart", cart);

        return "redirect:/cart/view";
    }
}
