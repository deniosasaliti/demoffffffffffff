package com.example.demo.config;



import com.example.demo.security.PrincipalDetailsService;


import com.example.demo.security.providers.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("com.example.demo.security.providers")
public class SecurityConf  extends WebSecurityConfigurerAdapter {

    final Provider provider;
//    final PrincipalDetailsService principalDetailsService;


    public SecurityConf(Provider provider) {
        this.provider = provider;


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/successPage").hasRole("ADMIN")
                .antMatchers("/login","/").permitAll()

                        .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/process")
                .failureUrl("/login?error=true")
                .usernameParameter("name")
                        .and()
                .exceptionHandling()

                        .and()
                .logout();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/js**");

    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(provider);
//        authenticationManagerBuilder.userDetailsService(principalDetailsService)

    }
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

}
