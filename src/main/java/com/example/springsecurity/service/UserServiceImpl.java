package com.example.springsecurity.service;

import com.example.springsecurity.model.entity.UserEntity;
import com.example.springsecurity.model.request.UserRequest;
import com.example.springsecurity.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity newUser(UserRequest userRequest) throws  Exception{
        String  passwordEncoder = new BCryptPasswordEncoder().encode(userRequest.getSenha());
        userRequest.setSenha(passwordEncoder);
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userRequest,UserEntity.class);
        return userRepository.save(userEntity);


    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }
}
