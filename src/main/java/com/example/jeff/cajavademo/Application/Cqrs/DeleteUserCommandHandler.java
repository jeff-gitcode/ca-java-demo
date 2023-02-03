package com.example.jeff.cajavademo.Application.Cqrs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

@Component
public class DeleteUserCommandHandler implements Command.Handler<DeleteUserCommand, Voidy> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Voidy handle(DeleteUserCommand command) {
        userRepository.deleteUser(command.id());
        return new Voidy();
    }
}
