package com.example.jeff.cajavademo.Application;

import java.util.List;
import java.util.Optional;

// import io.jkratz.mediator.core.Mediator;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.jeff.cajavademo.Application.Cqrs.CreateUserCommand;
import com.example.jeff.cajavademo.Application.Cqrs.DeleteUserCommand;
import com.example.jeff.cajavademo.Application.Cqrs.GetAllUsersQuery;
import com.example.jeff.cajavademo.Application.Cqrs.GetUserByIdQuery;
import com.example.jeff.cajavademo.Application.Cqrs.UpdateUserCommand;
import com.example.jeff.cajavademo.Application.Interface.API.IUserUseCase;
import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Voidy;

public class UserUseCase implements IUserUseCase {
    @Autowired
    protected Pipeline pipeline;

    @Override
    public Voidy createUser(UserDTO user) {
        var createUserCommand = new CreateUserCommand(user);

        return pipeline.send(createUserCommand);
    }

    @Override
    public Voidy updateUser(UserDTO user) {
        var UpdateUserCommand = new UpdateUserCommand(user);

        return pipeline.send(UpdateUserCommand);
    }

    @Override
    public Voidy deleteUser(String id) {
        var deleteUseCommand = new DeleteUserCommand(id);

        return pipeline.send(deleteUseCommand);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        var getAllUsersQuery = new GetAllUsersQuery();

        return pipeline.send(getAllUsersQuery);
    }

    @Override
    public UserDTO getUserById(String id) {
        var getUserQuery = new GetUserByIdQuery(id);

        return pipeline.send(getUserQuery);
    }
}
