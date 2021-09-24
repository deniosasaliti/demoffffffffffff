package com.example.demo.Entity;




import com.example.demo.validation.UniqueUserName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User  implements UserDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;



        @UniqueUserName
        @Size(max = 10 )
        private String name;

        @NotBlank(message = "a u IDIOT?")
        @Email(message = "a u IDIOT?")
        private String email;

        @NotBlank(message = "a u IDIOT?")
        private String password;

        @ManyToOne
        @JoinColumn(name = "role_id")
        private Role role;


        @Override
        public Collection<GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> authorities = new ArrayList<>();
                return authorities;
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
}




