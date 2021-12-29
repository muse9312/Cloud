package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue
    private String id;

    String name;
    int age;
    String grade;
    String job;
    int point;

    // @JsonIgnore
    // @OneToMany(mappedBy = "Customer")
    // List<Order> orderList = new ArrayList<>();
    // 주문내역이 0개인 고객도 있으므로 빈객체 생성

}
