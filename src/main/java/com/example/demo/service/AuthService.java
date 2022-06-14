package com.example.demo.service;

import com.example.demo.Dto.RefreshTokenRequest;
import com.example.demo.Dto.payload.AuthResponseDto;
import com.example.demo.Dto.payload.LoginRequestDto;
import com.example.demo.Dto.payload.SignUpRequestDto;
import com.example.demo.Entity.RefreshToken;
import com.example.demo.Entity.User;
import com.example.demo.repos.userRepos;
import com.example.demo.security.TokenProvider;
import com.example.demo.utilPojo.NotificationEmail;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthService {

    final userRepos userRepository;
    final TokenService tokenService;
    final MailService mailService;
    final AuthenticationManager authenticationManager;
    final TokenProvider tokenProvider;
    final PasswordEncoder passwordEncoder;

    final RefreshTokenService refreshTokenService;



    public ResponseEntity<AuthResponseDto> login(LoginRequestDto loginRequestDto){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(

                        loginRequestDto.getName(),
                        loginRequestDto.getPassword()
                )
        );

        User userForID = userRepository.findByName(loginRequestDto.getName());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        RefreshToken refreshToken = refreshTokenService.createToken();
        String token = tokenProvider.createToken(authentication);
        AuthResponseDto authResponseDto = AuthResponseDto.builder()
        .token(token)
        .expireTime(Date.from(Instant.now().plusMillis(30000)))
                .userId(userForID.getId())
                .refreshToken(refreshToken.getToken())
                .build();

        return ResponseEntity.ok(authResponseDto);
    }

    public AuthResponseDto refreshToken(RefreshTokenRequest refreshTokenRequest){

        System.out.println(refreshTokenRequest.getRefreshToken());
        System.out.println(refreshTokenRequest.getUserId());

        RefreshToken refreshToken = refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = tokenProvider.createTokenFromUserId(refreshTokenRequest.getUserId());

        log.info("in token refresh");
        return  AuthResponseDto.builder()
                .token(token)
                .refreshToken(refreshToken.getToken())
                .userId(refreshTokenRequest.getUserId())
                .expireTime(Date.from(Instant.now().plusMillis(30000)))
                .build();
    }




    @Transactional
    public void signup(SignUpRequestDto signUpRequestDto) throws Exception {

        User user = new User();
        user.setEmail(signUpRequestDto.getEmail());
        user.setName(signUpRequestDto.getUsername());
        user.setEmail(signUpRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequestDto.getPassword()));
        userRepository.save(user);


        String token = tokenService.generateVerificationToken(user);
//        NotificationEmail notificationEmail = new NotificationEmail("please activate your account",
//                user.getEmail(),"http://localhost:8080/accountVerification/");
//        Map<String,Object> model = new HashMap<>();
//        model.put("name",user.getName());
//        model.put("success",notificationEmail.getSuccessUrl()+token);
//
//
//
//        mailService.sendEmail(notificationEmail,model);
    }


}
