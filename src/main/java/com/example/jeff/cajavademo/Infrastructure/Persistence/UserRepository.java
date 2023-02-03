package com.example.jeff.cajavademo.Infrastructure.Persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;
import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Voidy;

@Repository
public class UserRepository implements IUserRepository {
    private List<UserDTO> users = new ArrayList<UserDTO>();

    @Override
    public Voidy createUser(UserDTO user) {
        users.add(user);

        return new Voidy();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        users = Collections.singletonList(new UserDTO("1", "Jeff", "Doe", "abc", "123"));
        return users;
    }

    @Override
    public UserDTO getUserById(String id) {
        var user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.orElse(null);
    }

    @Override
    public Voidy updateUser(UserDTO user) {
        users.stream().filter(u -> u.getId().equals(user.getId())).findFirst()
                .ifPresent(u -> u = user);
        return new Voidy();
    }

    @Override
    public Voidy deleteUser(String id) {
        users.removeIf(u -> u.getId().equals(id));
        return new Voidy();
    }
}
