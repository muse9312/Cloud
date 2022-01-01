package com.ggoreb.practice.service;

import com.ggoreb.practice.model.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public boolean addUser(User user);
}
