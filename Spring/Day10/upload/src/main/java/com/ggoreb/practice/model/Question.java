package com.ggoreb.practice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String subject;
	String content;

	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;
	
	@ManyToOne
	User user;
}
