package com.example.jeff.cajavademo.Application;

import java.util.List;
import java.util.Optional;

// import io.jkratz.mediator.core.Mediator;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.jeff.cajavademo.Application.Cqrs.CreateUserCommand;
import com.example.jeff.cajavademo.Application.Cqrs.GetAllUsersQuery;
import com.example.jeff.cajavademo.Application.Interface.API.IUserUseCase;
import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Pipeline;

public class UserUseCase implements IUserUseCase {
    @Autowired
    protected Pipeline pipeline;

    @Override
    public void createUser(UserDTO user) {
        var createUserCommand = new CreateUserCommand(user);

        pipeline.send(createUserCommand);
    }

    @Override
    public void updateUser(String id, UserDTO user) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Optional<UserDTO> getUser(String id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        var getAllUsersQuery = new GetAllUsersQuery();

        return pipeline.send(getAllUsersQuery);
    }
}
