package com.example.demo.service.impl;

import com.example.demo.Entity.User;
import com.example.demo.Entity.VerificationToken;
import com.example.demo.repos.VerificationTokenRepo;
import com.example.demo.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class TokenServiceImpl implements TokenService {
    final VerificationTokenRepo verificationTokenRepo;


    public TokenServiceImpl(VerificationTokenRepo verificationTokenRepo) {
        this.verificationTokenRepo = verificationTokenRepo;
    }

    @Transactional
    public String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepo.save(verificationToken);
        return token;
    }
}
