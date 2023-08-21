package com.jwtcookie.jwttokencookie.mapper;

import com.jwtcookie.jwttokencookie.dto.UserDto;
import com.jwtcookie.jwttokencookie.dto.UserLoggedDto;
import com.jwtcookie.jwttokencookie.model.Permission;
import com.jwtcookie.jwttokencookie.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDto userToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole().getAuthority(),
                user.getRole().getPermissions().stream().map(Permission::getAuthority).collect(Collectors.toSet())
        );
    }
    public static UserLoggedDto userToUserLoggedDto(User user) {
        return new UserLoggedDto(
                user.getUsername(),
                user.getRole().getAuthority(),
                user.getRole().getPermissions().stream().map(Permission::getAuthority).collect(Collectors.toSet())
        );
    }
}
