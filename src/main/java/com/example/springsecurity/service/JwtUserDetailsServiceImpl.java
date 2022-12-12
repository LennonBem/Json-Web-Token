package com.example.springsecurity.service;

import com.example.springsecurity.config.Security.Utils.JwtUSerFactory;
import com.example.springsecurity.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> funcionario =
                userService.findByEmail(username);
        if (funcionario.isPresent()) {
            return JwtUSerFactory.create(funcionario.get());
        }
        throw new UsernameNotFoundException("Email não encontrado.");
    }
}
