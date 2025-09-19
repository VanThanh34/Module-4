package com.codegym.exception;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("errorTitle", "ID không hợp lệ");
        model.addAttribute("errorMessage", "ID phải là một số nguyên hợp lệ!");
        return "product/error";
    }


    @ExceptionHandler(ProductsNotFoundException.class)
    public String handleNotFound(ProductsNotFoundException ex, Model model) {
        model.addAttribute("errorTitle", "Không tìm thấy sản phẩm");
        model.addAttribute("errorMessage", ex.getMessage());
        return "product/error";
    }
}
