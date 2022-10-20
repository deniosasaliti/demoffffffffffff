package com.example.demo.security;

import com.example.demo.service.AuthService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {


        try {
            String token = tokenProvider.resolveToken(httpServletRequest);

            if (token != null && tokenProvider.validateToken(token)) {
                Long userIdFromToken = tokenProvider.getUserIdFromToken(token);
                Authentication auth = tokenProvider.getAuth(userIdFromToken);

                SecurityContextHolder.getContext().setAuthentication(auth);

            }


            }catch (ExpiredJwtException e){

            logger.error("token expired or invalid");
        }

            filterChain.doFilter(httpServletRequest, httpServletResponse);


    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return (new AntPathMatcher().match("/auth/**", request.getServletPath()));


    }
}

