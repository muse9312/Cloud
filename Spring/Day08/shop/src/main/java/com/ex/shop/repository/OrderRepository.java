package com.ex.shop.repository;

import com.ex.shop.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
                extends JpaRepository<Order, Integer> {

}
