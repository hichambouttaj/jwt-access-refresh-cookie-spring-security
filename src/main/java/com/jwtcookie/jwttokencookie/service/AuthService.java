package com.jwtcookie.jwttokencookie.service;

import com.jwtcookie.jwttokencookie.dto.LoginRequest;
import com.jwtcookie.jwttokencookie.dto.LoginResponse;
import com.jwtcookie.jwttokencookie.dto.UserLoggedDto;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<LoginResponse> login(LoginRequest loginRequest, String accessToken, String refreshToken);

    ResponseEntity<LoginResponse> refresh(String refreshToken);

    ResponseEntity<LoginResponse> logout(String accessToken, String refreshToken);

    UserLoggedDto getUserLoggedInfo();
}
