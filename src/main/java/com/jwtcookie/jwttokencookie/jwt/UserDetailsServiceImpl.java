package com.jwtcookie.jwttokencookie.jwt;

import com.jwtcookie.jwttokencookie.exception.ResourceNotFoundException;
import com.jwtcookie.jwttokencookie.model.User;
import com.jwtcookie.jwttokencookie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
    }
}
