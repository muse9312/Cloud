package com.ggoreb.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ggoreb.practice.model.FileAtch;
import com.ggoreb.practice.model.Question;


public interface FileAtchRepository extends JpaRepository<FileAtch, Long> {
    FileAtch findByQuestion(Question question);

}
