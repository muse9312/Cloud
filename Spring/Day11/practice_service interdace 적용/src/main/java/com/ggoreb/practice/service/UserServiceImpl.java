package com.ggoreb.practice.service;

import com.ggoreb.practice.model.User;
import com.ggoreb.practice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean addUser(User user) {
        userRepository.save(user);
        return false;
    }

}
