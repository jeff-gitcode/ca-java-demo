package com.example.jeff.cajavademo.Application.Cqrs;

import java.util.List;

import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Command;

public record GetAllUsersQuery() implements Command<List<UserDTO>> {

}
