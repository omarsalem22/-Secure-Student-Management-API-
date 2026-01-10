package com.example.Spectro.services;


import com.example.Spectro.dto.AuthResponse;
import com.example.Spectro.dto.AuthenticationRequest;
import com.example.Spectro.dto.RegisterRequest;
import com.example.Spectro.entities.User;
import com.example.Spectro.enums.Role;
import com.example.Spectro.repositories.UserRepository;
import com.example.Spectro.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository ;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;


    public String register(RegisterRequest request) {
        var user = User.builder().email(request.getEmail()).username(request.getUsername()).password(passwordEncoder.encode(request.getPassword())).role(request.getRole()).build();

        userRepository.save(user);
        return "user registered successfully";
    }

    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));
        var jwtToken = jwtUtil.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();

    }

}
