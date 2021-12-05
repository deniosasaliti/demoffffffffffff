package com.example.demo.service;

import com.example.demo.utilPojo.NotificationEmail;
import com.example.demo.Entity.User;
import com.example.demo.repos.userRepos;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Map;

@Service
public class UserService {

    final userRepos userRepository;







    public UserService(userRepos userRepos) {

        this.userRepository = userRepos;

    }



//    @Transactional
//    public boolean isUserNameAlreadyUse(String userName){
//        boolean userInBd = true;
//        if (userRepository.findByName(userName) == null){
//            userInBd = false;
//        }
//        return userInBd;
//    }

    @Transactional
    public User findUserById(Long id){
        return     userRepository.findById(id).orElseThrow(
                    ()->new UsernameNotFoundException("user by " + id + "not found"));
    }


    @Transactional
    public User findUserByUserName(String name){
        return userRepository.findUsersByName(name)
                .orElseThrow(()-> new UsernameNotFoundException("user by " + name + "not found"));
    }









}
