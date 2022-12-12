package com.example.springsecurity.service;

import com.example.springsecurity.model.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    Optional<UserEntity> findByEmail(String email);
}
