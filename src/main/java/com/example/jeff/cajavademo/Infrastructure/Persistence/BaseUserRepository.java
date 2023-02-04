package com.example.jeff.cajavademo.Infrastructure.Persistence;

import java.beans.JavaBean;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jeff.cajavademo.Domain.User;

@Repository
public interface BaseUserRepository extends CrudRepository<User, String> {
}
