package com.example.jeff.cajavademo.Application.Cqrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;
import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

@Component
public class UpdateUserCommandHandler implements Command.Handler<UpdateUserCommand, UserDTO> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDTO handle(UpdateUserCommand command) {
        return userRepository.updateUser(command.user());
    }
}
