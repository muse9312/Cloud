package com.ggoreb.practice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String content;
	Date createDate;
	
	@ManyToOne
	User user;
	
	@ManyToOne
	Question question;
}
