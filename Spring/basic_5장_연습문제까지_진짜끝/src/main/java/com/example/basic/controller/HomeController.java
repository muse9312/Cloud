package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// Ctrl + P : 파일 찾아서 열기
// 자동완성 추천
// @Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
