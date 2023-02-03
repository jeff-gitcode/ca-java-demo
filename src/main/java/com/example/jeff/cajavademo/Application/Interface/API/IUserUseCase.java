package com.example.jeff.cajavademo.Application.Interface.API;

import java.util.List;
import java.util.Optional;

import com.example.jeff.cajavademo.Domain.UserDTO;

public interface IUserUseCase {
    void createUser(UserDTO user);

    void updateUser(String id, UserDTO user);

    void deleteUser(String id);

    Optional<UserDTO> getUser(String id);

    List<UserDTO> getAllUsers();

}
