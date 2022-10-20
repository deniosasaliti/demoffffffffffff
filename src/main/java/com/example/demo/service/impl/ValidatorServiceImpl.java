package com.example.demo.service.impl;

import com.example.demo.repos.userRepos;
import com.example.demo.service.ValidatorService;
import org.springframework.stereotype.Service;

@Service
public class ValidatorServiceImpl implements ValidatorService {

    private final userRepos userRepository;

    public ValidatorServiceImpl(userRepos userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUserNameAlreadyUse(String userName){
        boolean userInBd = true;
        if (userRepository.findByName(userName) == null){
            userInBd = false;
        }
        return userInBd;
    }
}
