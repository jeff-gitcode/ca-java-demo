package com.example.jeff.cajavademo.Application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jeff.cajavademo.Domain.UserDTO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUseCaseTest {
    private UserDTO user = new UserDTO("1", "John", "Doe", "john@doe.com", "123");

    @Autowired
    private UserUseCase userUseCase;

    @Test
    public void should_return_when_createUser() {
        var result = userUseCase.createUser(user);

        assertEquals(user, result);
    }

    @Test
    public void should_return_when_getUser() {
        var result = userUseCase.createUser(user);

        var actual = userUseCase.getUserById(user.getId());

        assertEquals(user, actual);
    }

    @Test
    public void should_return_when_getAllUsers() {

        var actual = userUseCase.getAllUsers();

        assertThat(actual.size(), greaterThan(0));
    }

    @Test
    public void should_return_when_updateUser() {
        var updatedUser = user;

        updatedUser.setFirstName("Jane");

        var actual = userUseCase.updateUser(updatedUser);

        assertEquals(updatedUser, actual);
    }
}
