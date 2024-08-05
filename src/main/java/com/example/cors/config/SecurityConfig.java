package com.example.cors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
////                                .requestMatchers("*","/","/linkedin/login").permitAll()
////                                .anyRequest().authenticated()
//                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .loginPage("/linkedin/login")
                                .defaultSuccessUrl("/user", true)
                );
//                .oauth2Login(oauth2Login ->
//                        oauth2Login
//                                .loginPage("/google/login")
//                                .loginProcessingUrl("/google/login")
//                                .defaultSuccessUrl("/google/user", true)
//                );
        return http.build();
    }
}

