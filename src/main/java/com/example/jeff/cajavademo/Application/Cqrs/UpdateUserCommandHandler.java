package com.example.jeff.cajavademo.Application.Cqrs;

import org.springframework.stereotype.Component;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

@Component
public class UpdateUserCommandHandler implements Command.Handler<UpdateUserCommand, Voidy> {
    private final IUserRepository userRepository;

    public UpdateUserCommandHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Voidy handle(UpdateUserCommand command) {
        userRepository.updateUser(command.user());
        return new Voidy();
    }
}
