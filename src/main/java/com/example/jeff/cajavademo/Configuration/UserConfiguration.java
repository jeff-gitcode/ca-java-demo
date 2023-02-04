package com.example.jeff.cajavademo.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.jeff.cajavademo.Application.UserUseCase;
import com.example.jeff.cajavademo.Infrastructure.Persistence.BaseUserRepository;

@Configuration
public class UserConfiguration {

    @Bean
    public UserUseCase createUserUseCase() {
        return new UserUseCase();
    }
}
