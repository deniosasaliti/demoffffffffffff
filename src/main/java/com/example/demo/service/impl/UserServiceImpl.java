package com.example.demo.service.impl;

import com.example.demo.Entity.User;
import com.example.demo.repos.userRepos;
import com.example.demo.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    final userRepos userRepository;







    public UserServiceImpl(userRepos userRepos) {

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
