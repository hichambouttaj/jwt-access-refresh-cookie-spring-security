package com.jwtcookie.jwttokencookie.dto;

import java.util.Set;

public record UserLoggedDto(String username, String role, Set<String> permissions) {
}
