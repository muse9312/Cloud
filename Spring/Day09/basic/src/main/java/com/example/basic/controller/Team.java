package com.example.basic.controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @OneToMany(mappedBy = "team")
    List<Player> players;
}
