package com.app.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.NewUserRequest;
import com.app.pojo.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to register a new user
    @PostMapping("/register")
    public User registerNewUser(@RequestBody NewUserRequest request) {
        return userService.registerNewUser(request);
    }
}

