package com.ksa.eat.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RestaurantTest {
  
  @Test
  public void creation() {
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
    assertEquals(restaurant.getId(), 1004L);
    assertEquals(restaurant.getName(), "Bob zip");
    assertEquals(restaurant.getAddress(), "Seoul");
  }

  @Test
  public void information() {
    Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul2");
    assertEquals(restaurant.getInformation(), "Bob zip in Seoul2");
  }
}
