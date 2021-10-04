//package com.example.demo.security.providers;
//import com.example.demo.Entity.User;
//import com.example.demo.repos.userRepos;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class Provider implements AuthenticationProvider {
//
//    final
//    userRepos userRepo;
//
//
//    public Provider(userRepos userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication)
//            throws AuthenticationException {
//        String name = authentication.getName();
//        User user = userRepo.findUsersByName(name);
//        if (user==null)
//            throw new UsernameNotFoundException("user not found");
//
//        String password = authentication.getCredentials().toString();
//        if (!password.equals(user.getPassword()))
//            throw new BadCredentialsException("Bad credentials");
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        return new UsernamePasswordAuthenticationToken(user,null,authorities);
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return aClass.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
