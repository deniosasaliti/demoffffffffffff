package com.example.demo.Dto.payload;

import lombok.Data;

@Data
public class AuthResponseDto {

    private String token;
    private String tokenType = "Bearer";


}
