package com.example.demo.service;

import com.example.demo.repos.userRepos;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ValidatorService {

    private final userRepos userRepository;

    public ValidatorService(userRepos userRepository) {
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
