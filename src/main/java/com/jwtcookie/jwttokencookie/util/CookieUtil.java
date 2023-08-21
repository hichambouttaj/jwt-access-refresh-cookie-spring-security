package com.jwtcookie.jwttokencookie.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {
    @Value("${JWT_ACCESS_COOKIE_NAME}")
    private String accessTokenCookieName;
    @Value("${JWT_REFRESH_COOKIE_NAME}")
    private String refreshTokenCookieName;
    public HttpCookie createAccessTokenCookie(String accessToken, long duration) {
        return ResponseCookie.from(accessTokenCookieName, accessToken)
                .maxAge(duration)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .build();
    }
    public HttpCookie createRefreshTokenCookie(String refreshToken, long duration) {
        return ResponseCookie.from(refreshTokenCookieName, refreshToken)
                .maxAge(duration)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .build();
    }
    public HttpCookie deleteAccessTokenCookie() {
        return ResponseCookie.from(accessTokenCookieName, "").maxAge(0).httpOnly(true).path("/").build();
    }
    public HttpCookie deleteRefreshTokenCookie() {
        return ResponseCookie.from(refreshTokenCookieName, "").maxAge(0).httpOnly(true).path("/").build();
    }
}
