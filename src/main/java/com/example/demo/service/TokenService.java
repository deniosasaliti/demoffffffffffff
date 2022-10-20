package com.example.demo.service;

import com.example.demo.Entity.User;

public interface TokenService {

    String generateVerificationToken(User user);
}
