package com.jwtcookie.jwttokencookie.dto;

public record LoginResponse(
        boolean isLogged,
        String role
) {
}
