package com.example.demo.Dto.payload;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
public class AuthResponseDto {

    private String token;
    private String tokenType = "Bearer";
    private String refreshToken;
    private Date expireTime;
    private long userId;



}
