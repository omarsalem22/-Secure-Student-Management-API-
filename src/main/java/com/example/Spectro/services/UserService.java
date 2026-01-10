package com.example.Spectro.services;

import com.example.Spectro.component.CustomUserDetails;
import com.example.Spectro.entities.User;
import com.example.Spectro.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class UserService  implements UserDetailsService {

private final UserRepository userRepository;


// i will load user by email as i'm using email to login   as register
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole().name());
        List<GrantedAuthority> authorities = List.of(authority);
        CustomUserDetails userDetails=CustomUserDetails.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
        return userDetails;


    }}
