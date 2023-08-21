package com.jwtcookie.jwttokencookie.dto;

import com.jwtcookie.jwttokencookie.model.Role;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;
public record UserDto (
        Long id,
        String username,
        String password,
        String role,
        Set<String> premissions
)implements Serializable { }