package com.example.shoppingcart.controller;

import com.example.shoppingcart.entity.Product;
import com.example.shoppingcart.exception.ProductNotFoundException;
import com.example.shoppingcart.repository.IProductRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final IProductRepository productRepository;

    @GetMapping("/view")
    public String viewCart(HttpSession session, Model model) {
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        Map<Product, Integer> cartDetails = new HashMap<>();
        double total = 0;

        if (cart != null) {
            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                Product product = productRepository.findById(entry.getKey()).orElseThrow();
                cartDetails.put(product, entry.getValue());
                total += product.getPrice() * entry.getValue();
            }
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("total", total);

        return "view/cart"; // cart/view.html
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, HttpSession session) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Không tìm thấy sản phẩm id=" + id));


        Map<Integer, Integer> cart = Optional.ofNullable(session.getAttribute("cart"))
                .filter(obj -> obj instanceof Map)
                .map(obj -> (Map<Integer, Integer>) obj)
                .orElse(new HashMap<>());


        cart.put(id, cart.getOrDefault(id, 0) + 1);


        session.setAttribute("cart", cart);

        return "redirect:/cart/view";
    }

    @GetMapping("/remove/{id}")
    public String removeItem(@PathVariable("id") Integer id, HttpSession session) {
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        if (cart != null) {
            cart.remove(id);
            session.setAttribute("cart", cart);
        }
        return "redirect:/cart/view";
    }


    @GetMapping("/clear")
    public String clearCart(HttpSession session) {
        session.removeAttribute("cart");
        return "redirect:/cart/view";
    }
}
