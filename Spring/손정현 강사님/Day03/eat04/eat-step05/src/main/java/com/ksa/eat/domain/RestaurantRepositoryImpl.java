package com.ksa.eat.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

  private List<Restaurant> restaurants = new ArrayList<>();

  public RestaurantRepositoryImpl() {
    restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
    restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
  }

  @Override
  public List<Restaurant> findAll() {
    return restaurants;
  }

  @Override
  public Restaurant findById(Long id) {
    Restaurant restaurant = (Restaurant) restaurants.stream()
      .filter(r -> r.getId().equals(id)) // id 변수 값과 같은 Restaurant 만 필터링
      .findFirst()   // 제일 첫번째 Restaurant 만 리턴 하라
      .orElse(null); // 데이터가 없을 경우 null 리턴 하라
    return restaurant;
  }

}
