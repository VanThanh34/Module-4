package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("save")
public class SandwichController {
    @RequestMapping
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        if(condiment == null){
           model.addAttribute("result","Không chọn nguyên liệu");
        } else {
            model.addAttribute("result", String.join(", ", condiment));
        }
        return "success";

    }
}
