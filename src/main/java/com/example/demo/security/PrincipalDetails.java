package com.example.demo.security;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrincipalDetails implements UserDetails {


    private Long id;
    private String name;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static PrincipalDetails create(User user) {
        return PrincipalDetails.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .authorities(toGrantedAuthority(user.getRole().getName()))
                .build();
    }

     private static List<GrantedAuthority> toGrantedAuthority (String role){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return  authorities;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }





}