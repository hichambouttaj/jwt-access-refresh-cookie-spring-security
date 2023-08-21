package com.jwtcookie.jwttokencookie.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "permissions", uniqueConstraints = {@UniqueConstraint(columnNames = {"resource", "operation"})})
public class Permission implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String resource;
    @Column(nullable = false)
    private String operation;
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;
    @Override
    public String getAuthority() {
        return String.format("%s:%s", resource.toUpperCase(), operation.toUpperCase());
    }
}
