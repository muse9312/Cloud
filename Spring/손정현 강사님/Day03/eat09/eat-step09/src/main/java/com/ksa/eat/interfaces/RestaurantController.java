package com.ksa.eat.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.ksa.eat.application.RestaurantService;
import com.ksa.eat.domain.MenuItem;
import com.ksa.eat.domain.MenuItemRepository;
import com.ksa.eat.domain.Restaurant;
import com.ksa.eat.domain.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
  
  // @Autowired
  // private RestaurantRepository respository;

  // // @Autowired
  // private MenuItemRepository menuItemRespository = new MenuItemRepositoryImpl();

  @Autowired
  private RestaurantService restaurantService;

  // 가게목록
  @GetMapping("/restaurants")
  public List<Restaurant> list() {
    // DB에서 가게 정보를 읽어오는 로직이 있을 것이다.
    // TODO DB에서 가게 정보 읽어오는 로직 작성
    List<Restaurant> restaurants = restaurantService.getRestaurants();
    return restaurants;
  }

  // 가게상세
  @GetMapping("/restaurants/{id}")
  public Restaurant detail(@PathVariable("id") Long id) {
    // TODO DB에서 가게 정보 읽어오는 로직 작성
    Restaurant restaurant = restaurantService.getRestaurant(id);
    return restaurant;    
  }

  // 가게등록
  @PostMapping("/restaurants")
  public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
    String name = resource.getName();
    String address = resource.getAddress();
    Restaurant restaurant = restaurantService.addRestaurant(new Restaurant(name, address));
    URI location = new URI("/restaurants/" + restaurant.getId());
    return ResponseEntity.created(location).body("{}");
  }
}
