package com.example.springsecurity.controller;

import com.example.springsecurity.config.Security.Utils.JwtTokenUtil;
import com.example.springsecurity.model.entity.UserEntity;
import com.example.springsecurity.model.request.UserRequest;
import com.example.springsecurity.model.response.UserResponse;
import com.example.springsecurity.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @GetMapping
    public ResponseEntity<Date> dkljfs(){
      return   ResponseEntity.ok(jwtTokenUtil.gerarDataExpiracao());
    }

    @PostMapping
    public ResponseEntity<Object> newUser(@RequestBody @Valid UserRequest userRequest) {
        try {

            UserEntity userEntity = userService.newUser(userRequest);
            ModelMapper modelMapper = new ModelMapper();
            UserResponse userResponse = modelMapper.map(userEntity, UserResponse.class);
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
          return   ResponseEntity.badRequest().body("Usuário já existe!");
        }
    }



}
