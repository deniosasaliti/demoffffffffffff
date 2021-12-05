package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
        String token = tokenProvider.resolveToken(httpServletRequest);

        if (token != null && tokenProvider.validateToken(token)){
            Long userIdFromToken = tokenProvider.getUserIdFromToken(token);
            Authentication auth = tokenProvider.getAuth(userIdFromToken);
            SecurityContextHolder.getContext().setAuthentication(auth);

        }
        } catch (Exception ex) {
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }



}

