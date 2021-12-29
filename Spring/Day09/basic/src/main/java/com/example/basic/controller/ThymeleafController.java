package com.example.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.basic.model.Hospital;
import com.example.basic.model.Sunbyul;
import com.example.basic.repository.HospitalRepository;
import com.example.basic.repository.SunbyulRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafController {
  @Autowired
  SunbyulRepository sunbyulRepository;

  @Autowired
  HospitalRepository hospitalRepository;

  @GetMapping("/hospital")
  public String hospital(Model model, 
        @RequestParam(defaultValue = "1") int page) {
    PageRequest pageRequest = PageRequest.of(page, 10);
    
    Page<Hospital> list = 
        hospitalRepository.findAll(pageRequest);

    int startPage = (page - 1) / 10 * 10 + 1;
    int endPage = startPage + 9;
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);
    model.addAttribute("page", page);
        
        
    model.addAttribute("list", list.getContent());

    return "hospital";
  }
  
  @GetMapping("pagination")
  public String pagination(
      Model model, @RequestParam(defaultValue = "1") int page) {
    int startPage = (page - 1) / 10 * 10 + 1;
    int endPage = startPage + 9;
    model.addAttribute("startPage", startPage);
    model.addAttribute("endPage", endPage);
    model.addAttribute("page", page);
    return "pagination";
  }

  @GetMapping("mode")
  public String mode(
      Model model, @RequestParam Map<String, Object> map) {
    model.addAttribute("name", map.get("name"));
    model.addAttribute("auth", map.get("auth"));
    model.addAttribute("category", map.get("category"));
    return "mode";
  }

  @GetMapping("/sunbyul/html")
  public String sunbyulHtml(Model model) {
    List<Sunbyul> list = sunbyulRepository.findAll();
    model.addAttribute("list", list);
    return "sunbyul";
  }

  @GetMapping("userList")
  public String userList(Model model) {
    List<Map<String, Object>> userList = 
      new ArrayList<>();
    Map<String, Object> user = null;
    user = new HashMap<>();
    user.put("userId", "a");
    user.put("userName", "apple");
    user.put("userAge", 21);
    userList.add(user);
    user = new HashMap<>();
    user.put("userId", "b");
    user.put("userName", "banana");
    user.put("userAge", 22);
    userList.add(user);
    user = new HashMap<>();
    user.put("userId", "c");
    user.put("userName", "carrot");
    user.put("userAge", 23);
    userList.add(user);
    model.addAttribute("userList", userList);
    return "userList";
  }

  @GetMapping("/user")
  public String user(
      Model model) {

    Map<String, Object> user = null;
    user = new HashMap<>();
    user.put("userId", "z");
    user.put("userName", "zoo");
    user.put("userAge", 25);
    model.addAttribute("user", user);

    model.addAttribute(
        "name", "park");
    model.addAttribute(
        "number", Math.random() * 45 + 1);

    return "user";
  }
}
