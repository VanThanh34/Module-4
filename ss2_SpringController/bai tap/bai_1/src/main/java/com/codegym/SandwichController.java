package com.codegym;

import com.codegym.Exception.NoCondimentSelectedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("save")
public class SandwichController {
    @RequestMapping
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        if (condiment == null || condiment.length == 0) {
            throw new NoCondimentSelectedException("Bạn chưa chọn nguyên liệu nào!");
        }

        model.addAttribute("result", String.join(", ", condiment));
        return "success";

    }
}
