package com.example.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(PageNotFoundException.class)
    public String handlePageNotFound(PageNotFoundException ex, Model model){
        model.addAttribute("error", "Trang bạn tìm không có");
        model.addAttribute("errorMess", ex.getMessage());
        return "blog/error";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
