package com.example.demo.service;

import com.example.demo.Dto.payload.AuthResponseDto;
import com.example.demo.Dto.payload.LoginRequestDto;
import com.example.demo.Dto.payload.SignUpRequestDto;
import com.example.demo.Entity.User;
import com.example.demo.repos.userRepos;
import com.example.demo.security.TokenProvider;
import com.example.demo.utilPojo.NotificationEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    final userRepos userRepository;
    final TokenService tokenService;
    final MailService mailService;
    final AuthenticationManager authenticationManager;
    final TokenProvider tokenProvider;

    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenProvider.createToken(authentication);
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setToken(token);
        return ResponseEntity.ok(authResponseDto);


    }

    @Transactional
    public void signup(SignUpRequestDto signUpRequestDto) throws Exception {

        User user = new User();
        user.setEmail(signUpRequestDto.getEmail());
        user.setName(signUpRequestDto.getUsername());
        user.setEmail(signUpRequestDto.getEmail());
        user.setPassword(signUpRequestDto.getPassword());
        userRepository.save(user);


        String token = tokenService.generateVerificationToken(user);
        NotificationEmail notificationEmail = new NotificationEmail("please activate your account",
                user.getEmail(),"http://localhost:8080/accountVerification/");
        Map<String,Object> model = new HashMap<>();
        model.put("name",user.getName());
        model.put("success",notificationEmail.getSuccessUrl()+token);



        mailService.sendEmail(notificationEmail,model);
    }


}
