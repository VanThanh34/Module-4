package com.example.shoppingcart.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFound(ProductNotFoundException ex, Model model){
        model.addAttribute("error", "Không tìm thấy sản phẩm!");
        model.addAttribute("errMess", ex.getMessage());
        return "view/error";
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMisMatch(MethodArgumentTypeMismatchException ex, Model model){
        model.addAttribute("error", "ID không hợp lệ");
        model.addAttribute("errMess", "ID phải là số nguyên hợp lệ");
        return "view/error";
    }
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntime(RuntimeException ex, Model model){
        model.addAttribute("error", "Mã mượn không tồn tại!");
//        model.addAttribute("errMess", ex.getMessage());
        return "view/error";
    }
}
