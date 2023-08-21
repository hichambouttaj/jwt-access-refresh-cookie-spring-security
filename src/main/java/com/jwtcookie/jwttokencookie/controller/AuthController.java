package com.jwtcookie.jwttokencookie.controller;

import com.jwtcookie.jwttokencookie.dto.LoginRequest;
import com.jwtcookie.jwttokencookie.dto.LoginResponse;
import com.jwtcookie.jwttokencookie.dto.UserLoggedDto;
import com.jwtcookie.jwttokencookie.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @CookieValue(name = "access_token", required = false) String accessToken,
            @CookieValue(name = "refresh_token", required = false) String refreshToken,
            @RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest, accessToken, refreshToken);
    }
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@CookieValue(name = "refresh_token", required = true) String refreshToken) {
        return authService.refresh(refreshToken);
    }
    @PostMapping("/logout")
    public ResponseEntity<LoginResponse> logout(
            @CookieValue(name = "access_token", required = false) String accessToken,
            @CookieValue(name = "refresh_token", required = false) String refreshToken) {
        return authService.logout(accessToken, refreshToken);
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/info")
    public ResponseEntity<UserLoggedDto> userLoggedInfo() {
        return ResponseEntity.ok(authService.getUserLoggedInfo());
    }
}
