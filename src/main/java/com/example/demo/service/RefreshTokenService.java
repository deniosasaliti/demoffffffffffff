package com.example.demo.service;

import com.example.demo.Entity.RefreshToken;
import com.example.demo.exceptions.SpringRedditException;
import com.example.demo.repos.RefreshTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class RefreshTokenService {

    final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }


    RefreshToken createToken(){
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
