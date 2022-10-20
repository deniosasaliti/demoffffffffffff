package com.example.demo.service.impl;

import com.example.demo.Entity.RefreshToken;
import com.example.demo.exceptions.SpringRedditException;
import com.example.demo.repos.RefreshTokenRepository;
import com.example.demo.service.RefreshTokenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class RefreshTokenServiceImpl implements RefreshTokenService {

    final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }


   public RefreshToken createToken(){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());
        return refreshTokenRepository.save(refreshToken);
    }

   public RefreshToken validateRefreshToken(String token){
       RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElseThrow(() ->
               new SpringRedditException("invalid refresh token"));
       refreshToken.setToken(UUID.randomUUID().toString());
       return refreshToken;
   }

   public void deleteToken(String token){
        refreshTokenRepository.deleteByToken(token);
    }
}
