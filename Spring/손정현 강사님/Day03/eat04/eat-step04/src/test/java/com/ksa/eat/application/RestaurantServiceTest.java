package com.ksa.eat.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.ksa.eat.domain.MenuItemRepository;
import com.ksa.eat.domain.MenuItemRepositoryImpl;
import com.ksa.eat.domain.Restaurant;
import com.ksa.eat.domain.RestaurantRepository;
import com.ksa.eat.domain.RestaurantRepositoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestaurantServiceTest {
  private RestaurantService restaurantService;

  // 테스트 케이스가 실행 돼기 전에 수행 해야 할 로직 정의
  @BeforeEach
  public void setUp() {
    RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
    MenuItemRepository menuItemRepository = new MenuItemRepositoryImpl();
    restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);    
  }

  @Test
  void testGetRestaurant() {
    Restaurant restaurant = restaurantService.getRestaurant(1004L);
    assertEquals(restaurant.getId(), 1004L);
  }

  @Test
  void testGetRestaurants() {
    List<Restaurant> restaurants = restaurantService.getRestaurants();
    Restaurant restaurant = restaurants.get(0);
    assertEquals(restaurant.getId(), 1004L);
  }
}
