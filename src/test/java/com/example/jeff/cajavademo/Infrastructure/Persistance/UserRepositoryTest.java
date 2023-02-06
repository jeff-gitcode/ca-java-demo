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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    private UserDTO user = new UserDTO("1", "John", "Doe", "john@doe.com", "123");

    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_return_when_createUser() {
        var result = userRepository.createUser(user);

        assertEquals(user, result);
    }

    @Test
    public void should_return_when_getUser() {
        var result = userRepository.getUserById(user.getId());

        assertEquals(user, result);
    }

    @Test
    public void should_return_when_updateUser() {
        var result = userRepository.updateUser(user);

        assertEquals(user, result);
    }

    @Test
    public void should_return_when_deleteUser() {
        var result = userRepository.deleteUser(user.getId());

        assertEquals(new Voidy(), result);
    }

}
