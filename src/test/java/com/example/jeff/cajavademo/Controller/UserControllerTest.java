package com.example.jeff.cajavademo.Controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

import static org.hamcrest.Matchers.is;
import org.hamcrest.Matchers;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
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

        var user = new UserDTO("1", "John", "Doe", "email", "password");

        // given(userUseCase.createUser(user)).willReturn(user);
        Mockito.when(userUseCase.createUser(user)).thenReturn(user);

        // mockMvc.perform(post("/api/users/createUser")
        // .contentType(MediaType.APPLICATION_JSON)
        // .content(user.toString()))
        // .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/users/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // .andExpect(jsonPath("$", Matchers.hasSize(1)))
        // .andExpect(jsonPath("$[1].fname", Matchers.is("abhi")));

        // mockMvc.perform(post("/api/users/createUser")
        // .contentType(MediaType.APPLICATION_JSON)
        // .content(user.toString()))
        // .andExpect(status().isOk());
        // .andExpect(jsonPath("$[1].fname", Matchers.is("abhi")));
        // .andDo(print())
        // .andReturn()
        // .getResponse()
        // .getContentAsString()
        // .equals(user.toString());

    }

}
