package com.codegym.c0525g1_spring_boot.controller;

import com.codegym.c0525g1_spring_boot.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Map;

public class DemoController {

    @GetMapping("/demo")
    public String view(@SessionAttribute("cart")Map<Student, Integer> cart) {
        return "demo";
    }
}
