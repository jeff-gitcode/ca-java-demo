package com.example.jeff.cajavademo.Infrastructure.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jeff.cajavademo.Application.UserUseCase;
import com.example.jeff.cajavademo.Domain.User;
import com.example.jeff.cajavademo.Domain.UserDTO;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        var result = userUseCase.createUser(user);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        var users = userUseCase.getAllUsers();

        return ResponseEntity.ok().body(users);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Void> updateUser(@RequestBody UserDTO user) {
        userUseCase.updateUser(user);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userUseCase.deleteUser(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        var user = userUseCase.getUserById(id);

        return ResponseEntity.ok().body(user);
    }
}
