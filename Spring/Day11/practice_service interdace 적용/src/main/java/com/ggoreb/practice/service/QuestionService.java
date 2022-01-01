package com.ggoreb.practice.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.ggoreb.practice.model.FileAtch;
import com.ggoreb.practice.model.Question;
import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.FileAtchRepository;
import com.ggoreb.practice.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
	QuestionRepository questionRepository;
    @Autowired
	FileAtchRepository fileAtchRepository;
    @Transactional
    public boolean addQuestion(Question question, User user, String fileName){
        question.setUser(user);
		question.setCreateDate(new Date());
		questionRepository.save(question);

        FileAtch fileAtch = new FileAtch();
		fileAtch.setFileName(fileName);
		fileAtch.setQuestion(question);
		fileAtchRepository.save(fileAtch);
        return false;

    }
    public List<Question> getQuestionList(int page){
        Page<Question> p = questionRepository.findAll(
            PageRequest.of(page - 1, 10, Sort.Direction.DESC, "createDate"));
    
    List<Question> list = p.getContent();
    return list;
    }
    
}
