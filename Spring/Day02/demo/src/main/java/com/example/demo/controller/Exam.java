package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class Exam {
    @GetMapping("html/exam")

    public String home() {
        return "exam";
    }

}
