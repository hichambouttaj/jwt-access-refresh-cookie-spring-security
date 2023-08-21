package com.jwtcookie.jwttokencookie.repository;

import com.jwtcookie.jwttokencookie.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}