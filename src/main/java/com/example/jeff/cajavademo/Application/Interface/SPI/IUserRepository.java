package com.example.jeff.cajavademo.Application.Interface.SPI;

import java.util.List;

import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Voidy;

public interface IUserRepository {
    public UserDTO createUser(UserDTO user);

    public List<UserDTO> getAllUsers();

    public UserDTO getUserById(String id);

    public UserDTO updateUser(UserDTO user);

    public Voidy deleteUser(String id);
}