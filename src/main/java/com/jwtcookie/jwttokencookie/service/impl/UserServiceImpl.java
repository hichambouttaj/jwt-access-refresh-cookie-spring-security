package com.jwtcookie.jwttokencookie.service.impl;

import com.jwtcookie.jwttokencookie.dto.UserDto;
import com.jwtcookie.jwttokencookie.mapper.UserMapper;
import com.jwtcookie.jwttokencookie.repository.UserRepository;
import com.jwtcookie.jwttokencookie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserMapper::userToUserDto).collect(Collectors.toList());
    }
}
