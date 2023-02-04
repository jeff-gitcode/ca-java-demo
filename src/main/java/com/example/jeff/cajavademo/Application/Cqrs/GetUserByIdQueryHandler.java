package com.example.jeff.cajavademo.Application.Cqrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;
import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Command;

@Component
public class GetUserByIdQueryHandler implements Command.Handler<GetUserByIdQuery, UserDTO> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDTO handle(GetUserByIdQuery command) {
        return userRepository.getUserById(command.id());
    }
}
