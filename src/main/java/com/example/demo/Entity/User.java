package com.example.demo.Entity;




import com.amazonaws.services.dynamodbv2.xspec.S;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


        @Column(name = "email")
        private String email;


        @Column(name = "password")
        private String password;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn( name = "role_id")
        private Role role;

        @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
        @JoinTable(name = "serial_user",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "serial_id")
        )
        private Set<Serial> serials = new HashSet<>();

}




