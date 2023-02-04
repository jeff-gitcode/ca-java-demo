package com.example.jeff.cajavademo.Application.Cqrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;
import com.example.jeff.cajavademo.Domain.UserDTO;
import an.awesome.pipelinr.Command;
import lombok.var;

// @AllArgsConstructor
@Component
public class CreateUserCommandHandler implements Command.Handler<CreateUserCommand, UserDTO> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDTO handle(CreateUserCommand command) {
        var user = command.user();

        return userRepository.createUser(user);

    }
}