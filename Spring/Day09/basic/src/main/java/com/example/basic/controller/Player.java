package com.example.basic.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue
    Long id;

    String name;

    @ManyToOne
    Team team;

}
