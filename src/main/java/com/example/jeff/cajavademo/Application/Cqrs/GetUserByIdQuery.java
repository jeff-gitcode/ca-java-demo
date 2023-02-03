package com.example.jeff.cajavademo.Application.Cqrs;

import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Command;

public record GetUserByIdQuery(String id) implements Command<UserDTO> {

}
