package com.near.Inventory_System.controller;

import com.near.Inventory_System.model.User;
import com.near.Inventory_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping("/user")
    public String test() {
        return "deu certo";
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.findByEmail(email);
    }
}
