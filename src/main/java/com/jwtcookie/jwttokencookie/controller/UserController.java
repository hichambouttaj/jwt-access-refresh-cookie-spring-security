package com.jwtcookie.jwttokencookie.controller;

import com.jwtcookie.jwttokencookie.dto.UserDto;
import com.jwtcookie.jwttokencookie.model.User;
import com.jwtcookie.jwttokencookie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto response = userService.create(userDto);
        return ResponseEntity.created(URI.create("/api/users/" + response.id())).body(response);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "userId") Long userId) {
        UserDto response = userService.getUser(userId);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable(name = "userId") Long userId,
            @RequestBody UserDto userDto
    ) {
        UserDto response = userService.updateUser(userId, userDto);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(
            @PathVariable(name = "userId") Long userId
    ) {
        String response = userService.deleteUser(userId);
        return ResponseEntity.ok(response);
    }
}
