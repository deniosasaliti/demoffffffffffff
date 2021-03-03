package com.example.demo.Entity;



import org.hibernate.engine.internal.StatefulPersistenceContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User  implements UserDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @OneToOne(
                cascade = CascadeType.ALL,mappedBy = "user",
                fetch = FetchType.LAZY,optional = false)
        private  VerificationToken verificationToken;


        @NotBlank(message = "a u IDIOT?")
        private String name;

        @NotBlank(message = "a u IDIOT?")
        @Email(message = "a u IDIOT?")
        @Column(name = "email")
        private String email;

        @NotBlank(message = "a u IDIOT?")
        @Column(name = "password")
        private String password;

    public User(Long userId, VerificationToken verificationToken,
                String name, String email, String password
                ) {
        this.id = userId;
        this.verificationToken = verificationToken;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public User() {

    }

    public void addToken(VerificationToken token){
        verificationToken = token;
        verificationToken.setUser(this);
    }

    public void removeToken(VerificationToken token){

        verificationToken = null;
    }


    public VerificationToken getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(VerificationToken verificationToken) {
        this.verificationToken = verificationToken;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getName();
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



}




