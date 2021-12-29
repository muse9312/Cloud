package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    String name;
    int count;
    String dest;
    Date ord_date;

}
