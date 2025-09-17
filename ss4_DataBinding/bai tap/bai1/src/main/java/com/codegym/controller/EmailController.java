package com.codegym.controller;

import com.codegym.entity.EmailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting")
public class EmailController {
    private EmailSettings settings = new EmailSettings("English", 25, true,"King, Asgard ");

    @GetMapping
    public String showForm(Model model){
        model.addAttribute("settings", settings);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5,10,15,25,50,100});

        return "settings";
    }

    @PostMapping
    public String update(@ModelAttribute("settings") EmailSettings updated, Model model){
        this.settings = updated;
        model.addAttribute("setting", settings);
        return "view";
    }
}
