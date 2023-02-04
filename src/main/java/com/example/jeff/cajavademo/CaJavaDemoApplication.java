package com.example.jeff.cajavademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.jeff.cajavademo.Infrastructure.Persistence.BaseUserRepository;

@SpringBootApplication(scanBasePackages={
	"com.example.jeff.cajavademo", "com.example.application"})

// @EnableCrudRepositories(basePackageClasses = BaseUserRepository.class)
public class CaJavaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaJavaDemoApplication.class, args);
	}

}
