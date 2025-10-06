package com.example.resource_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@Profile("")
public class SecurityConfig {

    @Bean
    @Profile("dev")
    SecurityFilterChain securityFilterChainDev(HttpSecurity http) throws Exception {
        return http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .authorizeHttpRequests(auth ->{
                auth.anyRequest().permitAll();
            })
            .oauth2ResourceServer(auth -> auth.disable())
            .build();
    }

    @Bean
    @Profile("!dev")
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
           .cors(cors -> cors.configurationSource(corsConfigurationSource()))
           .authorizeHttpRequests(auth ->{
               auth.requestMatchers("api/v1/products/**").hasAuthority("SCOPE_openid");
               auth.anyRequest().authenticated();
           })
           .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
           .build();
    }

    @Bean
    UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
