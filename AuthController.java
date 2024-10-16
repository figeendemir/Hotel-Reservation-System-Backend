package com.example.hotelapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.hotelapp.dto.LoginRequest;
import com.example.hotelapp.entities.User;
import com.example.hotelapp.repos.UserRepository;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUserName(loginRequest.getUsername());
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            // Authentication successful
            return ResponseEntity.ok().body("Login successful");
        } else {
            // Authentication failed
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
