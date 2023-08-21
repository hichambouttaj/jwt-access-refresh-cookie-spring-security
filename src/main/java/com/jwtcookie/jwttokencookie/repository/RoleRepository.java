package com.jwtcookie.jwttokencookie.repository;

import com.jwtcookie.jwttokencookie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}