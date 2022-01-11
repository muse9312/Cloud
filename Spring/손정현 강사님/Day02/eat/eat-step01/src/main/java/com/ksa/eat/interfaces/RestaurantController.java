package com.ksa.eat.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.ksa.eat.domain.Restaurant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
  
  // 가게목록
  @GetMapping("/restaurants")
  public List<Restaurant> list() {
    // DB에서 가게 정보를 읽어오는 로직이 있을 것이다.
    List<Restaurant> restaurants = new ArrayList<>();
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
    restaurants.add(restaurant);
    return restaurants;
  }

}
