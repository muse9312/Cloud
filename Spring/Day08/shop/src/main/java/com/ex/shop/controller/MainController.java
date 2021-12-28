package com.ex.shop.controller;

import java.util.List;

import com.ex.shop.model.Customer;
import com.ex.shop.model.Order;
import com.ex.shop.repository.CustomerRepository;
import com.ex.shop.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Ctrl + P : 파일 찾아서 열기
// 자동완성 추천
// @Controller

@Controller // RestController를 쓰면 html을 쓸수 없음
public class MainController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/order")
    public String order(Model model) {
        model.addAttribute(
                "list", orderRepository.findAll());
        return "order";
    }

    @ResponseBody
    @GetMapping("/order/json")
    public List<Order> orderJson() {
        return orderRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/customer/json")
    public List<Customer> CustomerJson() {
        return customerRepository.findAll();
    }
}
