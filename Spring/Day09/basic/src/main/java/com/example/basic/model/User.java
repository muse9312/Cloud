package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userId;
    private String userPw;
}