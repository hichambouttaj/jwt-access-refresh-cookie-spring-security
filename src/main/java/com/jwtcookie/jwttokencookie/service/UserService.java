package com.jwtcookie.jwttokencookie.service;

import com.jwtcookie.jwttokencookie.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
