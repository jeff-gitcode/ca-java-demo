package com.example.jeff.cajavademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableJpaRepositories("com.example.jeff.cajavademo.Infrastructure.Persistence")
public class CaJavaDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(CaJavaDemoApplication.class);

	public static void main(String[] args) {
		logger.info("Starting application...");

		SpringApplication.run(CaJavaDemoApplication.class, args);
	}

}
