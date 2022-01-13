package com.ksa.eat.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.ksa.eat.domain.MenuItem;
import com.ksa.eat.domain.MenuItemRepository;
import com.ksa.eat.domain.MenuItemRepositoryImpl;
import com.ksa.eat.domain.Restaurant;
import com.ksa.eat.domain.RestaurantRepository;
import com.ksa.eat.domain.RestaurantRepositoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {
  private RestaurantService restaurantService;

  @Mock
  private RestaurantRepository restaurantRepository;

  @Mock
  private MenuItemRepository menuItemRepository;

  // 테스트 케이스가 실행 돼기 전에 수행 해야 할 로직 정의
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);

    mockRestaurantRepository();

    mockMenuItemRepository();

    restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);    
  }

  private void mockMenuItemRepository() {
    List<MenuItem> menuItems = new ArrayList<>();
    menuItems.add(new MenuItem("Kimchi"));
    given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItems);
  }

  private void mockRestaurantRepository() {
    List<Restaurant> restaurants = new ArrayList<>();
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
    restaurants.add(restaurant);
    given(restaurantRepository.findAll()).willReturn(restaurants);
    given(restaurantRepository.findById(1004L)).willReturn(restaurant);
  }

  @Test
  void testGetRestaurant() {
    Restaurant restaurant = restaurantService.getRestaurant(1004L);
    assertEquals(restaurant.getId(), 1004L);
    MenuItem menuItem = restaurant.getMenuItems().get(0);
    assertEquals(menuItem.getName(), "Kimchi");
  }

  @Test
  void testGetRestaurants() {
    List<Restaurant> restaurants = restaurantService.getRestaurants();
    Restaurant restaurant = restaurants.get(0);
    assertEquals(restaurant.getId(), 1004L);
  }

  @Test
  void testAddRestaurant() {
    Restaurant restaurant = new Restaurant("BeRyong", "Busan");
    Restaurant create = restaurantService.addRestaurant(restaurant);
    assertEquals(create.getId(), 1234L);
  }
}
