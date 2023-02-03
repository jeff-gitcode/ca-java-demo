package com.example.jeff.cajavademo.Application.Interface.API;

import java.util.List;
import java.util.Optional;

import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Voidy;

public interface IUserUseCase {
    public Voidy createUser(UserDTO user);

    public List<UserDTO> getAllUsers();

    public UserDTO getUserById(String id);

    public Voidy updateUser(UserDTO user);

    public Voidy deleteUser(String id);

}
