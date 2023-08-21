package com.jwtcookie.jwttokencookie.exception;

import java.time.LocalDateTime;

public record ErrorDetails(
        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String details
){}
