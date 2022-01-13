package com.ksa.eat.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

  private String name;
  private String address;
  private long id;
  private List<MenuItem> menuItems = new ArrayList<>();

  public Restaurant(long id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
  
  public String getAddress() {
    return this.address;
  }

  public String getInformation() {
    return this.name + " in " + this.address;
  }

  public void addMenuItem(MenuItem menuItem) {
    this.menuItems.add(menuItem);
  }

  public List<MenuItem> getMenuItems() {
    return this.menuItems;
  }

  public void setMenuItem(List<MenuItem> menuItems) {
    for(MenuItem menuItem:menuItems) {
      addMenuItem(menuItem);
    }
  }

}
