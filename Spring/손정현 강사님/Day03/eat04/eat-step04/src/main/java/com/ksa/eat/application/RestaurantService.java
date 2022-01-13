package com.ksa.eat.application;

import java.util.List;

import com.ksa.eat.domain.MenuItem;
import com.ksa.eat.domain.MenuItemRepository;
import com.ksa.eat.domain.Restaurant;
import com.ksa.eat.domain.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

  @Autowired
  private RestaurantRepository restaurantRepository;
  @Autowired
  private MenuItemRepository menuItemRepository;

  public RestaurantService(RestaurantRepository restaurantRepository) {
    this.restaurantRepository = restaurantRepository;
  }

  public RestaurantService(RestaurantRepository restaurantRepository, 
    MenuItemRepository menuItemRepository) {
      this.restaurantRepository = restaurantRepository;
      this.menuItemRepository = menuItemRepository;
  }

  public Restaurant getRestaurant(Long id) {
    Restaurant restaurant = restaurantRepository.findById(id);
    List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
    restaurant.setMenuItem(menuItems);
    return restaurant;
  }

  public List<Restaurant> getRestaurants() {
    List<Restaurant> restaurants = restaurantRepository.findAll();
    return restaurants;
  }
}
