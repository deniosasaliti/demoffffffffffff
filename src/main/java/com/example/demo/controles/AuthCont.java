package com.example.demo.controles;


import com.example.demo.Dto.RefreshTokenRequest;
import com.example.demo.Dto.SerialD2;
import com.example.demo.Dto.SerialInfoDto;
import com.example.demo.Dto.payload.AuthResponseDto;
import com.example.demo.Dto.payload.LoginRequestDto;
import com.example.demo.Dto.payload.SignUpRequestDto;
import com.example.demo.Entity.AudioTrack;
import com.example.demo.Entity.RefreshToken;
import com.example.demo.Entity.Serial;
import com.example.demo.repos.SerialRepository;
import com.example.demo.security.TokenProvider;
import com.example.demo.service.AuthService;
import com.example.demo.service.RefreshTokenService;
import com.example.demo.service.SerialService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCont {

    private final AuthService authService;
    private final SerialRepository serialRepository;
    final SerialService serialService;
    final RefreshTokenService refreshTokenService;



    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> authUser(@RequestBody LoginRequestDto loginRequestDto){
        System.out.println(loginRequestDto);
        return authService.login(loginRequestDto);
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignUpRequestDto signUpRequestDto) throws Exception {
        authService.signup(signUpRequestDto);
        return new ResponseEntity<>("User Registration Successful", HttpStatus.OK);
    }

    @PostMapping("refreshToken")
    public ResponseEntity<AuthResponseDto> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
       return new ResponseEntity<>(authService.refreshToken(refreshTokenRequest),HttpStatus.OK);
    }

    @PostMapping("logout")
    public ResponseEntity<String> logout(@RequestBody RefreshTokenRequest refreshTokenRequest){
        refreshTokenService.deleteToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("refresh token deleted ");
    }

    @PostMapping("/getPostById")
    public ResponseEntity<SerialD2> getSerialById(@RequestParam long id){
        SerialD2 serial = serialService.getSerialByIdFetchAudios(id);


        return new ResponseEntity<>(serial,HttpStatus.OK);
    }



}
