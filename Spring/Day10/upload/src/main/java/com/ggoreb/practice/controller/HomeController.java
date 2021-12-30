package com.ggoreb.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ggoreb.practice.model.User;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "redirect:/question/list";
	}
}
