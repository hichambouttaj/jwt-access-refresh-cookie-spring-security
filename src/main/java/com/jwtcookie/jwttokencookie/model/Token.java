package com.jwtcookie.jwttokencookie.model;


import com.jwtcookie.jwttokencookie.enums.TokenType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TokenType type;
    private String value;
    private LocalDateTime expiryDate;
    private boolean disabled;
    @ManyToOne
    private User user;
}
