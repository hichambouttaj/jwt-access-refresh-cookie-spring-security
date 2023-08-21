package com.jwtcookie.jwttokencookie.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permissions {
    USER_READ("USER:READ"),
    USER_CREATE("USER:CREATE"),
    USER_UPDATE("USER:UPDATE"),
    USER_DELETE("USER:DELETE");
    private final String name;
}
