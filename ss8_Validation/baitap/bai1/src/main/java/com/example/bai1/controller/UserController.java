package com.example.bai1.controller;

import com.example.bai1.dto.UserDto;
import com.example.bai1.entity.User;
import com.example.bai1.service.IUserService;
import com.example.bai1.validation.UserValidation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final IUserService service;

    public UserController(IUserService service) {
        this.service = service;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("users", service.findALl());
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }

    @PostMapping("/create")
    public String addUser(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult,
                          RedirectAttributes redirect) {
        UserValidation userValidation = new UserValidation();
        userValidation.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        service.save(user);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/users";
    }
}
