package com.example.jeff.cajavademo.Infrastructure.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@RestController
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello() {
        return "Hello Jeff!";
    }
}
