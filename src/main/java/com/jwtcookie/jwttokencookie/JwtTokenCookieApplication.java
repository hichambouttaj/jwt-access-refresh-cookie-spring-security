package com.jwtcookie.jwttokencookie;

import com.jwtcookie.jwttokencookie.model.Permission;
import com.jwtcookie.jwttokencookie.model.Role;
import com.jwtcookie.jwttokencookie.model.User;
import com.jwtcookie.jwttokencookie.repository.RoleRepository;
import com.jwtcookie.jwttokencookie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class JwtTokenCookieApplication implements ApplicationRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(JwtTokenCookieApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createUsers();
    }
    public void createUsers() {
        if(!userRepository.findAll().isEmpty())
            return;

        Role roleAdmin = roleRepository.findById(2L).get();
        Role roleUser = roleRepository.findById(1L).get();
        Role roleManager = roleRepository.findById(3L).get();

        User admin = User.builder()
                .id(0L)
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .role(roleAdmin)
                .build();

        User user = User.builder()
                .id(0L)
                .username("user")
                .password(passwordEncoder.encode("user"))
                .role(roleUser)
                .build();

        User manager = User.builder()
                .id(0L)
                .username("manager")
                .password(passwordEncoder.encode("manager"))
                .role(roleManager)
                .build();

        userRepository.saveAll(List.of(user, admin, manager));
    }

}
