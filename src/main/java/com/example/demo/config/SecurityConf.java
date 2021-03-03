package com.example.demo.config;



import com.example.demo.providers.Provider;
import com.example.demo.service.UserDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import javax.servlet.FilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("com.example.demo.providers")
public class SecurityConf  extends WebSecurityConfigurerAdapter {

    final
    Provider provider;
    final
    UserDetService userDetailsService;

    public SecurityConf(Provider provider, UserDetService userDetailsService) {

        this.provider = provider;

        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("/login","/").permitAll()
                .antMatchers("/successPage").authenticated()
                        .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/process")
                .failureUrl("/login?error=true")
                .usernameParameter("name")
                        .and()
                .exceptionHandling()
                .accessDeniedPage("/successPage")
                        .and()
                .logout();
    }







    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(provider);



    }

}
