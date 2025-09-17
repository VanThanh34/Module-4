package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class CalculateController {
    @RequestMapping
public String calculate(@RequestParam("num1") double num1, @RequestParam("num2") double num2,@RequestParam("operation") String choice, Model model){
    double result = 0;
        switch (choice){
            case "Addition":
                result = num1 + num2;
                break;
                case "Subtraction":
                result = num1 - num2;
                break;
                case "Multiplication":
                result = num1 * num2;
                break;
                case "Division":
                if(num2 != 0){
                    result = num1 / num2;
                }else{
                    model.addAttribute("error", "Cant div 0!");
                    return "error";
                }
                break;
        }
        model.addAttribute("result", result);
        model.addAttribute("operation", choice);
        return "index";
}
}
