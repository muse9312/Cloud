package com.ksa.eat.domain;

public class Restaurant {

  private String name;
  private String address;
  private long id;

  public Restaurant(String name, String address) {
    this.name = name;
    this.address = address;
  }

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

  
}
