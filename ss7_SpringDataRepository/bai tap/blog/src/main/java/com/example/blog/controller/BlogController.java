package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.exception.PageNotFoundException;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private final IBlogService service;
    private final ICategoryService categoryService;
    public BlogController(IBlogService service, ICategoryService categoryService) {
        this.service = service;
        this.categoryService = categoryService;
    }
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }
//    Blog Blog = service.findById(id).orElseThrow(() ->
//            new BlogNotFoundException("Không tìm thấy blog với ID: " + id));
    @GetMapping
    public String findAll(Model model, @RequestParam(name = "page", defaultValue = "0")int page){
        Page<Blog> blogs = service.findAllPageable(page);
        if (page >= blogs.getTotalPages() && blogs.getTotalPages() > 0) {
            throw new PageNotFoundException("Trang " + page + " không tồn tại. Tổng số trang: " + blogs.getTotalPages());
        }
        model.addAttribute("blogs", blogs);
        model.addAttribute("notfound", "Chưa cập nhật Blog nào!");
        return "blog/list";
    }

    @GetMapping("/create")
    public String addBlog(Model model) {
        model.addAttribute("blogs", new Blog());
        return "blog/create";
    }

    //Dùng RequestBody để gửi dữ liệu dạng json từ postman qua bên db
    @PostMapping("/create")
    public String addBlog(@ModelAttribute("blogs") Blog blog, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "blog/create";
        }
        service.save(blog);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/blogs";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Blog Blog = service.findById(id).orElseThrow(() ->
                new BlogNotFoundException("Không tìm thấy blog với ID: " + id));
        model.addAttribute("blogs", Blog);
        return "blog/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Integer id,
                         @ModelAttribute Blog blog,Model model,
                         RedirectAttributes redirect) {
        Optional<Blog> existBlog = service.findById(id);

        if (existBlog.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy blog với ID: " + id);
            return "blog/error";
        }
        blog.setId(id);
        Category category = categoryService.findById(blog.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category không tồn tại"));

        blog.setCategory(category);
        service.update(blog);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/blogs";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirect) {
        Blog Blog = service.findById(id).orElse(null);

        if (Blog == null) {
            throw new BlogNotFoundException("Không tìm thấy blog với ID: " + id);
        }
        service.deleteById(id);
        redirect.addFlashAttribute("message", "Xoá blog thành công!");
        return "redirect:/blogs";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Blog blog = service.findById(id).orElseThrow(() ->

                new BlogNotFoundException("Không tìm thấy blog với ID: " + id));

        model.addAttribute("blogs", blog);
        return "blog/detail";
    }
}
