package com.example.demo.Entity;




import com.example.demo.validation.UniqueUserName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;



@Entity
@Table(name = "user" ,schema = "my_scheme")
public class User  implements UserDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;



        @UniqueUserName
        @Size(max = 10 )
        private String name;

        @NotBlank(message = "a u IDIOT?")
        @Email(message = "a u IDIOT?")
        @Column(name = "email")
        private String email;

        @NotBlank(message = "a u IDIOT?")
        @Column(name = "password")
        private String password;

    public User(Long userId, String name, String email, String password) {
        this.id = userId;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public User() {

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




