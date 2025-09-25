package com.example.bai1.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(BookNotFoundException.class)
    public String handleBookNotFound(BookNotFoundException ex, Model model){
        model.addAttribute("error", "Không tìm thấy sách!");
        model.addAttribute("errMess", ex.getMessage());
        return "book/error";
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMisMatch(MethodArgumentTypeMismatchException ex, Model model){
        model.addAttribute("error", "ID không hợp lệ");
        model.addAttribute("errMess", "ID phải là số nguyên hợp lệ");
        return "book/error";
    }
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntime(RuntimeException ex, Model model){
        model.addAttribute("error", "Mã mượn không tồn tại!");
//        model.addAttribute("errMess", ex.getMessage());
        return "book/error";
    }
}
