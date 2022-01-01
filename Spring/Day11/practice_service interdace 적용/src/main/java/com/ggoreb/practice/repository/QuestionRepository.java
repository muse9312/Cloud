package com.ggoreb.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggoreb.practice.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
