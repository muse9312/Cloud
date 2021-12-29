package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
    @GetMapping("/json/exam")
    @ResponseBody
    public Map<String, Object> jsonExam() {
        
        // 다형성, 제네릭<>
        Map<String, Object> m = 
            new HashMap<>(); // Map 생성 X
        m.put("count", 2);

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> m2 = new HashMap<>();
        m2.put("name", "가");
        m2.put("userId", "A");
        m2.put("userPassword", "1");
        list.add(m2);

        m.put("list", list);

        return m;
    }
}
