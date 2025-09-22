package com.example.blog.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMisMatch(MethodArgumentTypeMismatchException ex, Model model){
        model.addAttribute("error", "ID không hợp lệ");
        model.addAttribute("errorMess", "ID phải là số nguyên hợp lệ");
        return "blog/error";
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public String handleNotFound(BlogNotFoundException ex, Model model){
        model.addAttribute("error", "Không tìm thấy Blog");
        model.addAttribute("errorMess", ex.getMessage());
        return "blog/error";
    }
}
