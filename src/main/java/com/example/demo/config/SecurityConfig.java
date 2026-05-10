package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 테스트용 보안 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/signup").permitAll() // 회원가입 경로는 전부 접근 가능
                        .anyRequest().authenticated() // 나머지는 인증 필요
                );

        return http.build();
    }
}