package com.example.springsecurity.controller;

import com.example.springsecurity.model.request.LoginRequest;
import com.example.springsecurity.model.response.UserResponse;
import com.example.springsecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;



//    @PostMapping
//    public ResponseEntity<Object> loginByUsernameAndPassword(@RequestBody LoginRequest loginRequest){
//        try {
//          Object userResponse = loginService.loginByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
//          return ResponseEntity.ok(userResponse);
//        }catch (Exception e){
//      return   ResponseEntity.badRequest().body(e.getMessage());
//    }finally {
//
//        }
//        }
}
