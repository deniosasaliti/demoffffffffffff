package com.example.demo.controles;


import com.example.demo.Dto.payload.RefreshTokenRequest;
import com.example.demo.Dto.Serial.SerialD2;
import com.example.demo.Dto.payload.AuthResponseDto;
import com.example.demo.Dto.payload.LoginRequestDto;
import com.example.demo.Dto.payload.SignUpRequestDto;
import com.example.demo.repos.SerialRepository;
import com.example.demo.service.AuthService;
import com.example.demo.service.RefreshTokenService;
import com.example.demo.service.SerialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthCont {

    private final AuthService authService;
    private final SerialRepository serialRepository;
    final SerialService serialService;
    final RefreshTokenService refreshTokenService;




    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> authUser(@RequestBody LoginRequestDto loginRequestDto) {
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





}
