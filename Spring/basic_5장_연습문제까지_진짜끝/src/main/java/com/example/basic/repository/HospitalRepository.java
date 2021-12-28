package com.example.basic.repository;

import com.example.basic.model.Demo;
import com.example.basic.model.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository 
        extends JpaRepository<Hospital, Integer> {
    
}
