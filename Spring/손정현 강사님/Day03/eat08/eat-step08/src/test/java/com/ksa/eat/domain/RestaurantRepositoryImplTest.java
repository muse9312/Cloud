package com.ksa.eat.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RestaurantRepositoryImplTest {
  @Test
  void testSave() {
    RestaurantRepository repository = new RestaurantRepositoryImpl();
    int oldCount = repository.findAll().size();
    Restaurant restaurant = new Restaurant("BeRyong", "Busan");
    repository.save(restaurant);
    assertEquals(restaurant.getId(), 1234L);
    int newCount = repository.findAll().size();
    assertEquals(newCount - oldCount, 1);
  }
}
