package com.codegym.controller;

import com.codegym.service.IMoneyConvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/convert")

public class MoneyConvertController {

    private final IMoneyConvertService moneyConvertService;

    public MoneyConvertController(IMoneyConvertService moneyConvertService) {
        this.moneyConvertService = moneyConvertService;
    }

    @RequestMapping
    public String convert(@RequestParam("usd") double usd, Model model){
        if (usd > 0){
        double vnd = moneyConvertService.convertUsdToVnd(usd);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "result";
    } else{
            model.addAttribute("message", "Wrong Number!");
            return "fail";
        }
    }
}
