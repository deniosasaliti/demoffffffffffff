package com.example.demo.controles;


import com.example.demo.Dto.payload.AuthResponseDto;
import com.example.demo.Dto.payload.LoginRequestDto;
import com.example.demo.Dto.payload.SignUpRequestDto;
import com.example.demo.security.TokenProvider;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCont {

    private final AuthService authService;



    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> authUser(@Valid @RequestBody LoginRequestDto loginRequestDto){
        return authService.login(loginRequestDto);
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequestDto signUpRequestDto) throws Exception {
        authService.signup(signUpRequestDto);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }

}
