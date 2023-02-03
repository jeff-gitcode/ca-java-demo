package com.example.jeff.cajavademo.Application.Cqrs;

import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

public record CreateUserCommand(UserDTO user) implements Command<Voidy> {
}