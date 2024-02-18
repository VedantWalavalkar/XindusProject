package com.example.XindusProject.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){ return new BCryptPasswordEncoder();}

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/public/**", "/product/**")
                .permitAll()
                .requestMatchers("/user/**")
                .hasRole("USER")
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .and().logout();

        return httpSecurity.build();

    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserInfoUserServiceDetails();
    }

}
