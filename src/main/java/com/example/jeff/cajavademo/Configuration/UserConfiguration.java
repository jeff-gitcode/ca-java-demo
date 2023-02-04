package com.example.jeff.cajavademo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.jeff.cajavademo.Application.UserUseCase;

@Configuration
public class UserConfiguration {

    @Bean
    public UserUseCase createUserUseCase() {
        return new UserUseCase();
    }

    // @Bean
    // public UserRepository createUserRepository() {
    // return new UserRepository();
    // }
}
