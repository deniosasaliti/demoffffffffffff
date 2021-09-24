package com.example.demo.dto.payload;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

}
