package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Ctrl + P : 파일 찾아서 열기
// 자동완성 추천
@Controller
public class HomeController {
    @GetMapping("json2/string")
    @ResponseBody
    public String json() {
        return "json2/string";
    }

    @GetMapping("json2/map")
    @ResponseBody
    public Map<String, Object> jsonMap(Map<String, Object> map) {
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("key1", "value");
        map2.put("key2", 2324);
        map2.put("key3", true);
        return map2;
    }
}