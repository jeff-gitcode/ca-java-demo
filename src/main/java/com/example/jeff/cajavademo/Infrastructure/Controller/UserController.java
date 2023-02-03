package com.example.jeff.cajavademo.Infrastructure.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jeff.cajavademo.Application.UserUseCase;
import com.example.jeff.cajavademo.Domain.UserDTO;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping("/createUser")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO user) {
        userUseCase.createUser(user);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        var users = userUseCase.getAllUsers();

        return ResponseEntity.ok().body(users);
    }
}
