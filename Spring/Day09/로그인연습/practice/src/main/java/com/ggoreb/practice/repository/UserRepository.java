package com.ggoreb.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggoreb.practice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmailAndPwd(String email, String pwd);
}
