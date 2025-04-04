//package com.example.vehicleonboardingbackend.controller;
//
//import com.example.vehicleonboardingbackend.model.User;
//import com.example.vehicleonboardingbackend.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/register")
//    public User registerUser(@RequestParam String username, @RequestParam String password) {
//        return authService.registerUser(username, password);
//    }
//}