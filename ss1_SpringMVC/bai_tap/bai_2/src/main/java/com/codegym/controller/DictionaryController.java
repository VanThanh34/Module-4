package com.codegym.controller;

import com.codegym.Exception.InvalidWordException;
import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    private final IDictionaryService dictionary;

    public DictionaryController(IDictionaryService dictionary) {
        this.dictionary = dictionary;
    }

    @RequestMapping
    public String search(@RequestParam("eng") String eng, Model model) {

        if (eng.matches("\\d+")) {
            throw new InvalidWordException("Không nhập số! Mời nhập lại từ.");
        }

        String result = dictionary.search(eng.toLowerCase());

        model.addAttribute("word", eng);
        model.addAttribute("meaning", result);

        return "result";
    }

}
