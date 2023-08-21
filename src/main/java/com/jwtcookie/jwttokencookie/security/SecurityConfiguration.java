package com.jwtcookie.jwttokencookie.security;

import com.jwtcookie.jwttokencookie.enums.Permissions;
import com.jwtcookie.jwttokencookie.jwt.AuthenticationFilterImpl;
import com.jwtcookie.jwttokencookie.jwt.JwtAuthEntryPoint;
import com.jwtcookie.jwttokencookie.jwt.JwtAuthFilter;
import com.jwtcookie.jwttokencookie.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    public static final String SWAGGER_UI_URL = "/swagger-ui/**";
    public static final String API_DOCS_URL = "/v3/api-docs/**";
    public static final String[] ALLOWED_URLS = {
            SWAGGER_UI_URL, API_DOCS_URL
    };
    private final JwtAuthFilter jwtAuthFilter;
    private final JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);
        http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(Collections.singletonList("http://localhost:5173"));
                    configuration.setAllowedMethods(Collections.singletonList("*"));
                    configuration.setAllowCredentials(true);
                    configuration.setAllowedHeaders(Collections.singletonList("*"));
                    configuration.setMaxAge(3600L);
                    return configuration;
                }));
        http
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(ALLOWED_URLS).permitAll();
                    authorize.requestMatchers("/api/auth/login").permitAll();
                    authorize.requestMatchers("/api/auth/refresh").permitAll();
                    authorize.requestMatchers(HttpMethod.GET, "/api/users/**").hasAuthority(Permissions.USER_READ.getName());
                    authorize.requestMatchers(HttpMethod.POST, "/api/users/**").hasAuthority(Permissions.USER_CREATE.getName());
                    authorize.requestMatchers(HttpMethod.PUT, "/api/users/**").hasAuthority(Permissions.USER_UPDATE.getName());
                    authorize.requestMatchers(HttpMethod.DELETE, "/api/users/**").hasAuthority(Permissions.USER_DELETE.getName());
//                    authorize.anyRequest().permitAll();
                    authorize.anyRequest().authenticated();
                });
        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint));
        http
//                .formLogin(login -> login.loginProcessingUrl("/api/auth/login"))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
