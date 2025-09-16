package com.codegym.HandleException;


import com.codegym.Exception.InvalidWordException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(InvalidWordException.class)
    public String handleInvalidWordException(InvalidWordException ex, Model model) {
        model.addAttribute("errorTitle", "Lỗi nhập từ điển");
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}
