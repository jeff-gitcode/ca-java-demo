package com.example.jeff.cajavademo.Application.Cqrs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;
import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Command;

@Component
public class GetAllUsersQueryHandler implements Command.Handler<GetAllUsersQuery, List<UserDTO>> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UserDTO> handle(GetAllUsersQuery command) {
        return userRepository.getAllUsers();
    }
}