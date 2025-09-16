package com.codegym.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/convert")
public class MoneyConvertController {



    @RequestMapping
    public String convert(@RequestParam("usd") double usd, Model model){
        if (usd > 0){
        double rate = 25000;
        double vnd = rate * usd;
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "result";
    } else{
            model.addAttribute("message", "Wrong Number!");
            return "fail";
        }
    }
}
