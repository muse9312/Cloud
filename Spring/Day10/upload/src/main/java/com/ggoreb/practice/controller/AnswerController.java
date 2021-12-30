package com.ggoreb.practice.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import com.ggoreb.practice.model.Answer;
import com.ggoreb.practice.model.Question;
import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.AnswerRepository;
import com.ggoreb.practice.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping("/answer/create")
    public String createAnswer(@ModelAttribute Answer answer, @RequestParam Long question_id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        answer.setUser(user);
        answer.setCreateDate(new Date());

        Question question = questionRepository.findById(question_id).get();

        answer.setQuestion(question);

        answerRepository.save(answer);
        return "redirect:/question/list";
    }

}
