package com.example.basic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class JavaBoard {
    @Id   
    @GeneratedValue
    int id;
    String title;
    String content;
    String memberId;
    Date creDate;
}
