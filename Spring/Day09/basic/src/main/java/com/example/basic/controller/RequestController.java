package com.example.basic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.basic.model.Member;
import com.example.basic.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class RequestController {
  @GetMapping("req/data")
  public Map data(@RequestParam Map map) {
    return map;
  }

  // 컨트롤러 메소드
  @GetMapping("req/model")
  public String model(@ModelAttribute Member member) {
    return member.toString();
  }

  @GetMapping("req/addUser")
  public User addUser(
    @ModelAttribute("user") User user) {
    return user;
  }

  @GetMapping("req/http")
  public String http(HttpServletRequest request) {
    String name = request.getParameter("name");
    String pageNum = request.getParameter("pageNum");
    return name + ", " + pageNum;
  }

  @GetMapping("req/param1")
  public String param1(
      @RequestParam(required = false, defaultValue = "1") 
            String key1,
      @RequestParam("key2") String key2, 
      @RequestParam String key3,
      String key4) {
    return key1 + ", " + key2 + ", " + key3 + ", " + key4;
  }

  @GetMapping("req/param2")
  public String param2(
    @RequestParam Map<String, Object> map) {

    return map.toString();

  }

  @GetMapping("req/path/{path1}/{path2}")
  public String path(
      @PathVariable("path1") String path1,
      @PathVariable("path2") String path2) {
    return path1 + ", " + path2;
  }
  
}
