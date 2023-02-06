package com.example.jeff.cajavademo.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.jeff.cajavademo.Application.UserUseCase;
import com.example.jeff.cajavademo.Domain.UserDTO;
import com.example.jeff.cajavademo.Infrastructure.Controller.UserController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import an.awesome.pipelinr.Voidy;

import static org.hamcrest.Matchers.is;
import org.hamcrest.Matchers;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    private UserDTO user = new UserDTO("1", "John", "Doe", "email", "password");
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserUseCase userUseCase;

    private UserController _sut;

    public UserControllerTest() {
        _sut = new UserController(userUseCase);
    }

    @Test
    public void should_return_when_createUser() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Mockito.when(userUseCase.createUser(user)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/users/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userUseCase, times(1)).createUser(user);
        verifyNoMoreInteractions(userUseCase);
    }

    @Test
    public void should_return_when_getUserById() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Mockito.when(userUseCase.getUserById("1")).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/users/getUserById/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userUseCase, times(1)).getUserById("1");
        verifyNoMoreInteractions(userUseCase);
    }

    @Test
    public void should_return_when_updateUser() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Mockito.when(userUseCase.updateUser(user)).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/api/users/updateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userUseCase, times(1)).updateUser(user);
        verifyNoMoreInteractions(userUseCase);
    }

    @Test
    public void should_return_when_deleteUser() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Mockito.when(userUseCase.deleteUser("1")).thenReturn(new Voidy());

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/users/deleteUser/1")
                .contentType(MediaType.APPLICATION_JSON))
                // .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userUseCase, times(1)).deleteUser("1");
        verifyNoMoreInteractions(userUseCase);
    }
}
