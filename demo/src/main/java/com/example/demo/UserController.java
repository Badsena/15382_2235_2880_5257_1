package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        if (userRepo.existsById(user.getEmail())) {
            return ResponseEntity.badRequest().body("User already exists with this email");
        }
        userRepo.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
