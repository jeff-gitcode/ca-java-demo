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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // TODO Auto-generated method stub
        users = Collections.singletonList(new UserDTO("1", "Jeff", "Doe", "abc", "123"));
        return users;
    }
}
