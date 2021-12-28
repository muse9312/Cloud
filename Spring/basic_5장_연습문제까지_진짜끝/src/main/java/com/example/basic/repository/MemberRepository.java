package com.example.basic.repository;

import com.example.basic.model.Demo;
import com.example.basic.model.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository 
        extends JpaRepository<Member, Long> {
    
}
