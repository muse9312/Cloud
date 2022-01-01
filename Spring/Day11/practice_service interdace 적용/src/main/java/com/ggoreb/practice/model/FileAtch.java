package com.ggoreb.practice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class FileAtch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

    String fileName;
    @OneToOne
    Question question;
}