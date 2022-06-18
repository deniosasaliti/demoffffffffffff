package com.example.demo.service;

import com.example.demo.Dto.payload.RefreshTokenRequest;
import com.example.demo.Dto.payload.AuthResponseDto;
import com.example.demo.Dto.payload.LoginRequestDto;
import com.example.demo.Dto.payload.SignUpRequestDto;
import com.example.demo.Entity.RefreshToken;
import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.repos.RoleRepository;
import com.example.demo.repos.userRepos;
import com.example.demo.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    final RoleRepository roleRepository;

    @Value("${token.expired.time}")
    private long tokenExpireTime;



    public ResponseEntity<AuthResponseDto> login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(

                        loginRequestDto.getName(),
                        loginRequestDto.getPassword()


                )
        );

        User userForID = userRepository.findByName(loginRequestDto.getName())
                .orElseThrow(()-> new UsernameNotFoundException("user by username " +
                        loginRequestDto.getName() + " not found"));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        RefreshToken refreshToken = refreshTokenService.createToken();
        String token = tokenProvider.createToken(authentication);
        AuthResponseDto authResponseDto = AuthResponseDto.builder()
        .token(token)
        .expireTime(Date.from(Instant.now().plusMillis(tokenExpireTime)))
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
                .expireTime(Date.from(Instant.now().plusMillis(tokenExpireTime)))
                .build();
    }




    @Transactional
    public void signup(SignUpRequestDto signUpRequestDto) throws Exception {

        Role role = new Role();
        role.setName("userRole");
        roleRepository.save(role);
        User user = new User();
        user.setRole(role);
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
