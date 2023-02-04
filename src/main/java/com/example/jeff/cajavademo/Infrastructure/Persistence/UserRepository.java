package com.example.jeff.cajavademo.Infrastructure.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;
import com.example.jeff.cajavademo.Domain.User;
import com.example.jeff.cajavademo.Domain.UserDTO;

import an.awesome.pipelinr.Voidy;

@Repository
public class UserRepository implements IUserRepository {

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    // @Autowired
    // private BaseUserRepository baseUserRepository;

    private List<UserDTO> users = new ArrayList<>() {
        {
            add(new UserDTO("1", "John", "Doe", "john@doe.com", "123"));
        }
    };

    @Override
    public UserDTO createUser(UserDTO user) {
        logger.info("Creating user: " + user.toString());

        var uuid = UUID.randomUUID();
        user.setId(uuid.toString());

        users.add(user);

        return user;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        logger.info("Getting all users");

        return users;
    }

    @Override
    public UserDTO getUserById(String id) {
        logger.info("Getting user by id: " + id);

        var user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.orElse(null);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        logger.info("Updating user: " + userDTO.toString());

        users.stream().filter(u -> u.getId().equals(userDTO.getId())).findFirst()
                .ifPresent(u -> {
                    u.setFirstName(userDTO.getFirstName());
                    u.setLastName(userDTO.getLastName());
                    u.setEmail(userDTO.getEmail());
                    u.setPassword(userDTO.getPassword());
                });

        var user = users.stream().filter(u -> u.getId().equals(userDTO.getId())).findFirst();
        return user.orElse(null);
    }

    @Override
    public Voidy deleteUser(String id) {
        logger.info("Deleting user by id: " + id);

        users.removeIf(u -> u.getId().equals(id));
        return new Voidy();
    }
}
