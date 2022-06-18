package com.example.demo.security;

import com.example.demo.exceptions.SpringRedditException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TokenProvider {

    @Value("${token.secret}")
    private String tokenSecret;

    @Value("${token.expired.time}")
    private Long tokenExpireTime;

    final  PrincipalDetailsService principalDetailsService;




    public String createToken(Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();


        Claims claims = Jwts.claims().setSubject(principalDetails.getId().toString());
//        claims.put("roles",principalDetails.getAuthorities().toString());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusMillis(tokenExpireTime)))
                .signWith(SignatureAlgorithm.HS512,tokenSecret)
                .compact();
    }


    public String  createTokenFromUserId(Long userId){


        Claims claims = Jwts.claims().setSubject(userId.toString());
//        claims.put("Permissions",principalDetails.getAuthorities().toString());


        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plusMillis(tokenExpireTime)))
                .signWith(SignatureAlgorithm.HS512,tokenSecret)
                .compact();
    }

    public Authentication getAuth(Long id){
        UserDetails userDetails = principalDetailsService.loadUserById(id);
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());

    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(tokenSecret)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) throws SpringRedditException {

            Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(authToken);
            return true;


    }


    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken!=null && bearerToken.startsWith("Bearer_")){
            return bearerToken.substring(7);
        }
        return null;
    }
}
