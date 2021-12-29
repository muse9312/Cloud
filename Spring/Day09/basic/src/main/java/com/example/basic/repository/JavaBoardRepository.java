package com.example.basic.repository;

import com.example.basic.model.Demo;
import com.example.basic.model.JavaBoard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JavaBoardRepository 
  extends JpaRepository<JavaBoard, Integer> {
    
}
