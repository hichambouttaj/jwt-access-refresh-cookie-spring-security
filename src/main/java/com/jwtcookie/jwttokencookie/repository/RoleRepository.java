package com.jwtcookie.jwttokencookie.repository;

import com.jwtcookie.jwttokencookie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}