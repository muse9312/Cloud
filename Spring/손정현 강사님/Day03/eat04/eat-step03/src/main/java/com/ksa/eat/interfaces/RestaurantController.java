package com.ksa.eat.interfaces;

import java.util.List;

import com.ksa.eat.domain.MenuItem;
import com.ksa.eat.domain.MenuItemRepository;
import com.ksa.eat.domain.MenuItemRepositoryImpl;
import com.ksa.eat.domain.Restaurant;
import com.ksa.eat.domain.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
  
  @Autowired
  private RestaurantRepository respository;

  // @Autowired
  private MenuItemRepository menuItemRespository = new MenuItemRepositoryImpl();

  // 가게목록
  @GetMapping("/restaurants")
  public List<Restaurant> list() {
    // DB에서 가게 정보를 읽어오는 로직이 있을 것이다.
    // TODO DB에서 가게 정보 읽어오는 로직 작성
    List<Restaurant> restaurants = respository.findAll();
    return restaurants;
  }

  // 가게상세
  @GetMapping("/restaurants/{id}")
  public Restaurant detail(@PathVariable("id") Long id) {
    // TODO DB에서 가게 정보 읽어오는 로직 작성
    Restaurant restaurant = respository.findById(id);
    List<MenuItem> menuItems = menuItemRespository.findAllByRestaurantId(id);
    restaurant.setMenuItem(menuItems);
    return restaurant;    
  }

}
