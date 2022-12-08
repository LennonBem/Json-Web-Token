package com.example.springsecurity.model.request;

import com.example.springsecurity.model.entity.AddressEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleRequest {

    @NotBlank(message = "Nome é obrigatório!")
    private String name;
    @NotBlank(message = "CPF é obrigatório!")

    private Long cpf ;
    @NotBlank(message = "idade é obrigatório!")
    private int age ;
    @NotBlank(message = "telefone é obrigatório!")
    private Long cel ;

    @NotBlank(message = " é obrigatório!")
    private UUID addressID ;
}