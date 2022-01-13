package com.ksa.eat.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepository {

  private List<MenuItem> menuItes = new ArrayList<>();

  
  public MenuItemRepositoryImpl() {
    menuItes.add(new MenuItem("Kimchi"));
  }

  @Override
  public List<MenuItem> findAllByRestaurantId(Long id) {
    return menuItes;
  }
  
}
