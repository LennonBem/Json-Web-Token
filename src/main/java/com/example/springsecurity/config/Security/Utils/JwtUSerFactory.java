package com.example.springsecurity.config.Security.Utils;

import com.example.springsecurity.model.Enum.PerfilEnum;
import com.example.springsecurity.model.entity.UserEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Data
public class JwtUSerFactory {
    public static JwtUser create(UserEntity usuario) {
        return new JwtUser(usuario.getUserID(), usuario.getEmail(),
                usuario.getSenha(),
                mapToGrantedAuthorities(usuario.getPerfil()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(
            PerfilEnum perfilEnum) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
        return authorities;
    }
}
