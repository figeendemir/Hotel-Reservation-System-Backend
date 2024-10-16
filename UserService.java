package com.example.hotelapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hotelapp.entities.User;
import com.example.hotelapp.repos.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); 
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword())); 
        return userRepository.save(newUser);
    }

    public User getOneUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(passwordEncoder.encode(newUser.getPassword())); 
            foundUser.setEmail(newUser.getEmail());
            userRepository.save(foundUser);
            return foundUser;
        } else {
            return null;
        }
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUserWithReservations(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            user.getReservations().size(); 
        }
        return user;
    }

    public void changePassword(String username, String newPassword) {
        User user = userRepository.findByUserName(username);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}
