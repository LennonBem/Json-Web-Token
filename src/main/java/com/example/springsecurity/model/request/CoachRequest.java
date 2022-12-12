package com.example.springsecurity.model.request;

import com.example.springsecurity.model.entity.PeopleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoachRequest {
    @NotBlank(message = "Inscrição é obrigatório!")
    private int inscricao;
    @NotBlank(message = "Pessoa é obrigatório!")
    private UUID peopleID ;

}