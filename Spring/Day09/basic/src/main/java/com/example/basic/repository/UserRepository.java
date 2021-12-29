package com.example.basic.repository;

import com.example.basic.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository 
    extends JpaRepository<User, Integer> {
    User findByUserIdAndUserPw(
        String userId, String userPw);
}
