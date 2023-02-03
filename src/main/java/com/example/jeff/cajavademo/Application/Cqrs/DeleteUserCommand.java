package com.example.jeff.cajavademo.Application.Cqrs;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Voidy;

public record DeleteUserCommand(String id) implements Command<Voidy> {

}
