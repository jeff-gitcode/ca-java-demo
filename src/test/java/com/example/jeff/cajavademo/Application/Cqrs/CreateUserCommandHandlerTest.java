package com.example.jeff.cajavademo.Application.Cqrs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.jeff.cajavademo.Application.Cqrs.CreateUserCommand;
import com.example.jeff.cajavademo.Domain.UserDTO;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.jeff.cajavademo.Application.Interface.SPI.IUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateUserCommandHandlerTest {
    private UserDTO user = new UserDTO("1", "John", "Doe", "john@doe.com", "123");

    @MockBean
    private IUserRepository userRepository;

    @Autowired
    private CreateUserCommandHandler createUserCommandHandler;

    @Test
    public void should_return_when_handle_createusercommand() {
        Mockito.when(userRepository.createUser(user)).thenReturn(user);

        var result = createUserCommandHandler.handle(new CreateUserCommand(user));

        assertEquals("1", result.getId());
    }
}
