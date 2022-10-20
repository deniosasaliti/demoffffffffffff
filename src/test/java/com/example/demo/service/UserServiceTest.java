package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.VerificationToken;
import com.example.demo.repos.VerificationTokenRepo;
import com.example.demo.repos.userRepos;
import com.example.demo.service.impl.UserServiceImpl;
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
    UserServiceImpl service;
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