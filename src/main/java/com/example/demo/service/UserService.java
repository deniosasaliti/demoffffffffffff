package com.example.demo.service;

import com.example.demo.Entity.User;

public interface UserService {

    User findUserById(Long id);

    User findUserByUserName(String name);
}
