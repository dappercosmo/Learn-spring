package com.flyway.flyway_example.controller;

import com.flyway.flyway_example.model.Users;
import com.flyway.flyway_example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;

    @PostMapping("registerUser")
    ResponseEntity<Users> registerUser(@RequestBody Users users){
        try{
            userService.registerUser(users);
            return ResponseEntity.ok(users);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }

    }
}
