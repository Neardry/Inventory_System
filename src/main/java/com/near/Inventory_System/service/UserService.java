package com.near.Inventory_System.service;

import com.near.Inventory_System.model.User;
import com.near.Inventory_System.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailNotAvaliable(String email) {
        return userRepository.findByEmail(email) != null;
    }
    public boolean isNameNotAvaliable(String name) {
        return userRepository.findByName(name) != null;
    }

}
