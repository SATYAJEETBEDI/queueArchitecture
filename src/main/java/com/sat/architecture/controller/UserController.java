package com.sat.architecture.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sat.architecture.config.User;
import com.sat.architecture.repository.UserRepo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/")
    public ResponseEntity<Map<String,String>> userEntry(@RequestBody User user) {
        userRepo.save(user);
        Map<String,String> response = new HashMap<>();
        response.put("message", "user added");
        return ResponseEntity.ok(response);
    }
    
}
