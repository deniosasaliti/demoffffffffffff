package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.VerificationToken;
import com.example.demo.Entity.Vote;
import com.example.demo.repos.VerificationTokenRepo;
import com.example.demo.repos.VoteRepo;
import com.example.demo.repos.userRepos;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class UserServiceTest {
    @Autowired
    UserService service;
    @Autowired
    VerificationTokenRepo tokenRepo;
    @Autowired
    userRepos userRepository;


    @Test
    void  someTest(){
        VerificationToken token = tokenRepo.findById(1L).get();
    }

    @Test
    void  someTest2(){
        User user = userRepository.findById(1L).get();
    }










}