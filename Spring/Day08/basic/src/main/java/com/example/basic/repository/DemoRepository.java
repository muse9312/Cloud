package com.example.basic.repository;

import com.example.basic.model.Demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository 
        extends JpaRepository<Demo, Long> {
    
}
