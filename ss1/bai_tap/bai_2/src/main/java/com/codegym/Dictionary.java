package com.codegym;

import com.codegym.Exception.InvalidWordException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dictionary")
public class Dictionary {
    private static final Map<String, String> dictionary = new HashMap<>();


    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("goodbye", "tạm biệt");
        dictionary.put("cat", "con mèo");
        dictionary.put("dog", "con chó");
        dictionary.put("school", "trường học");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
    }
    @RequestMapping
    public String search(@RequestParam("eng") String eng, Model model) {

        if (eng.matches("\\d+")) {
            throw new InvalidWordException("Không được nhập số! Vui lòng nhập chữ cái.");
        }

        String result = dictionary.get(eng.toLowerCase());

        if (result == null) {
            result = "Không tìm thấy trong từ điển.";
        }

        model.addAttribute("word", eng);
        model.addAttribute("meaning", result);

        return "result";
    }

}
