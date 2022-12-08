package com.example.springsecurity.config.Security.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationDto {

    @NotEmpty(message = "Email não pode ser vazio.")
    @Email(message = "Email inválido.")
    private String email;
    @NotEmpty(message = "Senha não pode ser vazia.")
    private String senha;
}
