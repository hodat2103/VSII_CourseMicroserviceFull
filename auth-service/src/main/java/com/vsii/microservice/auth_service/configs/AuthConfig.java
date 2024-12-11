//package com.vsii.microservice.auth_service.configs;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebSecurity
//public class AuthConfig {
//
//    // Security Filter Chain updated for Spring Security 6.x
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(csrf -> csrf.disable()) // Disabling CSRF
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/v1/auth/**").permitAll() // Updated to use requestMatchers
//                        .anyRequest().authenticated() // Default to authenticated for other requests
//                )
//                .build();
//    }
//
//    // AuthenticationManager bean configuration remains the same
//    @Bean
//    public AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    // PasswordEncoder bean configuration remains the same
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // WebSecurityCustomizer updated for Spring Security 6.x
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//                .requestMatchers("/v1/auth/**",
//                        "/swagger-resources/**",
//                        "/swagger-ui.html/**",
//                        "/swagger-resources/**",
//                        "/swagger-ui/**",
//                        "/v3/api-docs/**"); // Updated to use requestMatchers
//    }
//
//    // CORS Configuration
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("*"); // Allow all methods for CORS
//            }
//        };
//    }
//}
