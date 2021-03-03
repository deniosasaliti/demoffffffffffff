package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.VerificationToken;
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

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findUserByUserName() {
        User ddd = service.findUserByUserName("ddd");
        Assertions.assertNotNull(ddd);
    }

    @Test
    void deleteToken(){
        service.removeToken("Denis");
    }


}