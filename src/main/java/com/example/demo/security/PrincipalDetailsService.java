package com.example.demo.security;

import com.example.demo.Entity.User;
import com.example.demo.repos.userRepos;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final userRepos userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User usersByName = userRepository.findUsersByName(s);
        return PrincipalDetails.create(usersByName);
    }
}
