//package com.example.vehicleonboardingbackend.service;
//
//import com.example.vehicleonboardingbackend.model.User;
//import com.example.vehicleonboardingbackend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//
//    private final UserRepository userRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public User registerUser(String username, String password) {
//        if (userRepository.findByUsername(username).isPresent()) {
//            throw new RuntimeException("Username already exists!");
//        }
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        return userRepository.save(user);
//    }
//}