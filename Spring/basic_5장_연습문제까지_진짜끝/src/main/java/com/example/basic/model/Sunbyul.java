package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Sunbyul {
    @Id
    @GeneratedValue
    int id;
    String sido;
    String gugun;
    String name;
    String address;
    String tel;
}
