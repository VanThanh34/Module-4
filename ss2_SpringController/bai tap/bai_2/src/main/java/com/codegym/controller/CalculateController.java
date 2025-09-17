package com.codegym.controller;

import com.codegym.service.ICalculateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class CalculateController {
    private final ICalculateService calculateService;

    public CalculateController(ICalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @RequestMapping
public String calculate(@RequestParam("num1") double num1, @RequestParam("num2") double num2,@RequestParam("operation") String choice, Model model){
        double result = calculateService.calculate(num1, num2, choice);
        model.addAttribute("result", result);
        model.addAttribute("operation", choice);
        return "index";
}
}
