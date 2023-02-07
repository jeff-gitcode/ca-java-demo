package com.example.jeff.cajavademo.Infrastructure.Persistance;

import org.junit.runner.RunWith;
import com.example.jeff.cajavademo.Domain.UserDTO;
import com.example.jeff.cajavademo.Infrastructure.Persistence.UserRepository;

import an.awesome.pipelinr.Voidy;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    private UserDTO user = new UserDTO("1", "John", "Doe", "john@doe.com", "123");
    private UserDTO result;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
    }

    @Test
    @Order(1)
    public void should_return_when_getAllUsers() {
        var actual = userRepository.getAllUsers();

        assertThat(actual.size(), greaterThan(0));
    }

    @Test
    public void should_return_when_createUser() {
        result = userRepository.createUser(user);

        assertEquals(user, result);
    }

    @Test
    public void should_return_when_getUser() {
        result = userRepository.createUser(user);

        var actual = userRepository.getUserById(user.getId());

        assertEquals(user, actual);
    }

    @Test
    public void should_return_when_updateUser() {
        var actual = userRepository.updateUser(user);

        assertEquals(user, actual);
    }

    @Test
    public void should_return_when_deleteUser() {
        var actual = userRepository.deleteUser(user.getId());

        assertEquals(new Voidy(), actual);
    }

}
