package com.ksa.eat.domain;

import java.util.List;

public interface MenuItemRepository {
  List<MenuItem> findAllByRestaurantId(Long id);
}
