package com.example.springsecurity.model.request;

import com.example.springsecurity.model.Enum.PerfilEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {
    @NotBlank(message = "Username é obrigatório!")
    private String email;
    @NotBlank(message = "Password é obrigatório!")
    private String senha;

    private PerfilEnum perfil;

        }
