package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.exception.ProductsNotFoundException;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", service.findAll());
        model.addAttribute("notfound", "Không có sản phẩm nào");
        return "product/list";
    }


    @GetMapping("/create")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        service.save(product);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Product product = service.findById(id);
        if (product == null) {
            throw new ProductsNotFoundException("Không tìm thấy sản phẩm với ID: " + id);
        }
        model.addAttribute("product", product);
        return "product/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirect) {
        service.update(product);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        Product product = service.findById(id);
        if (product == null) {
            throw new ProductsNotFoundException("Không tìm thấy sản phẩm với ID: " + id);
        }
        service.deleteById(id);
        redirect.addFlashAttribute("message", "Xoá sản phẩm thành công!");
        return "redirect:/products";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Product product = service.findById(id);
        if (product == null) {
            throw new ProductsNotFoundException("Không tìm thấy sản phẩm với ID: " + id);
        }
        model.addAttribute("product", product);
        return "product/detail";
    }

}
