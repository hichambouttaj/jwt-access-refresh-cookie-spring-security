package com.jwtcookie.jwttokencookie.service.impl;

import com.jwtcookie.jwttokencookie.dto.UserDto;
import com.jwtcookie.jwttokencookie.exception.ResourceNotFoundException;
import com.jwtcookie.jwttokencookie.mapper.UserMapper;
import com.jwtcookie.jwttokencookie.model.Role;
import com.jwtcookie.jwttokencookie.model.User;
import com.jwtcookie.jwttokencookie.repository.RoleRepository;
import com.jwtcookie.jwttokencookie.repository.UserRepository;
import com.jwtcookie.jwttokencookie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(UserMapper::userToUserDto).collect(Collectors.toList());
    }
    @Override
    public UserDto create(UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);

        // get role from db
        Role role = roleRepository.findByName(userDto.role()).orElseThrow(
                () -> new ResourceNotFoundException("Role not found")
        );

        user.setRole(role);
        user.setPassword(passwordEncoder.encode(userDto.password()));

        return UserMapper.userToUserDto(userRepository.save(user));
    }
    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
        return UserMapper.userToUserDto(user);
    }
    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        // get user from db
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );

        // get role from db
        Role role = roleRepository.findByName(userDto.role()).orElseThrow(
                () -> new ResourceNotFoundException("Role not found")
        );

        user.setUsername(userDto.username());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setRole(role);

        return UserMapper.userToUserDto(userRepository.save(user));
    }
    @Override
    public String deleteUser(Long userId) {
        // get user from db
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );

        userRepository.delete(user);

        return String.format("User with %d deleted successfully", userId);
    }
}
