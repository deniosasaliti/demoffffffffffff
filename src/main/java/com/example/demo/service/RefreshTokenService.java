package com.example.demo.service;

import com.example.demo.Entity.RefreshToken;

public interface RefreshTokenService {

    RefreshToken createToken();

    RefreshToken validateRefreshToken(String token);

    void deleteToken(String token);
}
