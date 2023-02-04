package com.example.jeff.cajavademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.jeff.cajavademo.Infrastructure.Persistence.BaseUserRepository;

@SpringBootApplication
// @EnableJpaRepositories("com.example.jeff.cajavademo.Infrastructure.Persistence")
public class CaJavaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaJavaDemoApplication.class, args);
	}

}
