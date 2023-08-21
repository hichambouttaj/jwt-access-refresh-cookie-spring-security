package com.jwtcookie.jwttokencookie.repository;

import com.jwtcookie.jwttokencookie.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
}