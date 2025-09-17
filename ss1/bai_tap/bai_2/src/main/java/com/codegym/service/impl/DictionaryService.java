package com.codegym.service.impl;

import com.codegym.Exception.InvalidWordException;
import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
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

    @Override
    public String search(String eng) {
            String result = dictionary.get(eng.toLowerCase());
            if (result == null) {
                throw new InvalidWordException("Không có trong từ điển hoặc nhập sai!");
            }
            return result;

    }
}
