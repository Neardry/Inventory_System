package com.near.Inventory_System.controller;

import com.near.Inventory_System.model.User;
import com.near.Inventory_System.repository.UserRepository;
import com.near.Inventory_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {
    private UserRepository userRepository;
    private UserService userService;
    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {

        if(userService.isEmailNotAvaliable(user.getEmail())) {
            return ResponseEntity.badRequest().body("O email já está em uso");
        }
        if(userService.isNameNotAvaliable(user.getName())) {
            return ResponseEntity.badRequest().body("O nome já está em uso");
        }
         userRepository.save(user);
        return ResponseEntity.ok("Usuário criado com sucesso!");
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
