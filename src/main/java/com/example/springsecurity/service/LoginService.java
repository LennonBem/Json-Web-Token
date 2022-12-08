package com.example.springsecurity.service;

import com.example.springsecurity.config.ModelMapper.Mapper;
import com.example.springsecurity.model.entity.UserEntity;
import com.example.springsecurity.model.response.LoginResponse;
import com.example.springsecurity.model.response.UserResponse;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springfox.documentation.spring.web.json.Json;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    Mapper mapper;
    @Autowired
    UserRepository userRepository;

//    public Object loginByUsernameAndPassword(String username, String password) throws Exception {
//
//      UserEntity user = userRepository.findByEmail(username).orElseThrow(
//              () -> new Exception("Usuário não existe!") );
//
//       if(passwordValid(password, user.getPassword())){
//         LoginResponse loginResponse =  mapper.modelMapper().map(user,LoginResponse.class);
//           String authorizationString =  username + ":" + password;
//           String authorizationBase64 =  Base64.getEncoder().encodeToString(authorizationString.getBytes());
//           loginResponse.setAuthorization("Basic " + authorizationBase64);
//
//
//
//
//         return loginResponse;
//       }else {
//       throw new Exception("Senha inválida");
//       }
//
//
//
//    }

    private  boolean passwordValid(String password, String encoderPassword) {
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       return   encoder.matches(password,encoderPassword );
    }
}
