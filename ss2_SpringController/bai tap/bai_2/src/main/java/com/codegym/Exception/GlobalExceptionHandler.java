package com.codegym.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("error", "Invalid Number!");
        return "error";
    }
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmetic(ArithmeticException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error";
    }
}

