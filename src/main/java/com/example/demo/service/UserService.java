package com.example.demo.service;

import com.example.demo.Entity.NotificationEmail;
import com.example.demo.Entity.User;
import com.example.demo.Entity.VerificationToken;
import com.example.demo.repos.VerificationTokenRepo;
import com.example.demo.repos.userRepos;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final Map<String, Object> model = new HashMap<>();

    final userRepos userRepos;
    final VerificationTokenRepo verificationTokenRepo;
    final MailService mailService;





    public UserService(userRepos userRepos, VerificationTokenRepo verificationTokenRepo, MailService mailService) {
        this.userRepos = userRepos;
        this.verificationTokenRepo = verificationTokenRepo;
        this.mailService = mailService;
    }


    @Transactional
    public User findUserByUserName(String name){
        return userRepos.findUsersByName(name);
    }


   @Transactional
    public void saveUser(User user) throws Exception {

        NotificationEmail notificationEmail = new NotificationEmail("please activate your account",
                user.getEmail(),"http://localhost:8080/accountVerification/");
        String token = generateVerificationToken(user);
        model.put("name",user.getName());
        model.put("success",notificationEmail.getSuccessUrl()+token);
        userRepos.save(user);
        mailService.sendEmail(notificationEmail,model);

    }

    @Transactional
    public VerificationToken  removeToken(String name){
        VerificationToken token = verificationTokenRepo.findById(11L).get();
return token;
    }

    @Transactional
    public User  removeUser(String name){
        User user = userRepos.findById(11L).get();
        return user;

    }



   private String generateVerificationToken(User user) {
       String token = UUID.randomUUID().toString();
       VerificationToken verificationToken = new VerificationToken();
       verificationToken.setToken(token);
       verificationToken.setUser(user);
        verificationTokenRepo.save(verificationToken);
        return token;
   }
}
