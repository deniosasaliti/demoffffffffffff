package com.example.demo.Dto.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class LoginRequestDto {


    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 14, message = "Password length must be from 8 to 14 symbols")
    private String password;
}
