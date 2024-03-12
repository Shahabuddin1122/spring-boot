package com.dsi.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {
                    request.requestMatchers("/jurnal/**","/clubs","/clubs/**", "/api/v1/admin/login","/api/v1/","/api/v1/products","/api/v1/products/{id}").permitAll()
                            .requestMatchers("/api/v1/user/**").hasAuthority("ROLE_USER")
                            .requestMatchers("/api/v1/admin/**").hasAuthority("ROLE_ADMIN")
                            .anyRequest().authenticated();
//                    request.requestMatchers("/**").permitAll();
                })
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

}
