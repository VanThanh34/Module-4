package com.HandlerException;



import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GlobalException {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, Model model) {
        model.addAttribute("errorTitle", "Không chọn nguyên liệu!");
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model){
        model.addAttribute("errorTitle", "Không nguyên liệu!");
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}