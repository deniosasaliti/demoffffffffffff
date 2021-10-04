package com.example.demo.Entity;




import com.example.demo.validation.UniqueUserName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User  {


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
}




