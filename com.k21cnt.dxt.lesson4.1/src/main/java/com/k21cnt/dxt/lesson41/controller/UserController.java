package com.k21cnt.dxt.lesson41.controller;


import com.k21cnt.dxt.lesson41.dto.UserDTO;
import com.k21cnt.dxt.lesson41.entity.User;
import com.k21cnt.dxt.lesson41.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user-list")
    public List<User> getAllUser(){
        return userService.findAll();
    }
    @PostMapping("/user-add")
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO user){
        userService.create(user);
        return ResponseEntity.badRequest().body("User created successfully");
    }
}
