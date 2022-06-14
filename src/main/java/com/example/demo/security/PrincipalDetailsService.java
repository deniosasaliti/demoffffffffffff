package com.example.demo.security;

import com.example.demo.Entity.User;
import com.example.demo.repos.userRepos;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final userRepos userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       User usersByName = userRepository.findUsersByName(userName)
               .orElseThrow(()-> new UsernameNotFoundException("user by " + userName +"not found"))  ;
        return PrincipalDetails.create(usersByName);
    }



    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("user by id " + id + " not found")
        );
        return PrincipalDetails.create(user);
    }
}