package com.example.jeff.cajavademo.Application.Cqrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;
import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;
import lombok.var;

// @AllArgsConstructor
@Component
public class CreateUserCommandHandler implements Command.Handler<CreateUserCommand, Voidy> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Voidy handle(CreateUserCommand command) {
        var user = command.user();

        userRepository.createUser(user);

        return new Voidy();
    }
}