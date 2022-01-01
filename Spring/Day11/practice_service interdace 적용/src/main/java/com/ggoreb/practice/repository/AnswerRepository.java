package com.ggoreb.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.ggoreb.practice.model.Answer;
import com.ggoreb.practice.model.Question;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);

}
