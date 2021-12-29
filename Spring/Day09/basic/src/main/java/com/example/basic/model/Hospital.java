package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hospital {
    @Id
    int id;
    String sido;
    String name;
    int medical;
    int room;
    String tel;
    String address;
}
