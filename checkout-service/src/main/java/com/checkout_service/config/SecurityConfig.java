package com.checkout_service.config;

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
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/checkout/{id}", "/checkout/**").hasAnyAuthority("SCOPE_email")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer((oauth2 -> oauth2
                        .jwt(jwt ->jwt
                                .jwkSetUri("http://localhost:8080/realms/dh/protocol/openid-connect/certs"))));

        return http.build();
    }


}