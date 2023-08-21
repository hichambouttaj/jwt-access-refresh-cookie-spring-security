package com.jwtcookie.jwttokencookie.service;

import com.jwtcookie.jwttokencookie.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();

    UserDto create(UserDto userDto);

    UserDto getUser(Long userId);

    UserDto updateUser(Long userId, UserDto userDto);

    String deleteUser(Long userId);
}
