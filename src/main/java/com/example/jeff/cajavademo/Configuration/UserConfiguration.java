package com.example.jeff.cajavademo.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.jeff.cajavademo.Application.UserUseCase;

@Configuration
public class UserConfiguration {
    // @Autowired
    // private UserRepository userRepository;

    @Bean
    public UserUseCase createUserUseCase() {
        return new UserUseCase();
    }
}
