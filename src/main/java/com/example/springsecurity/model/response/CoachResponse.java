package com.example.springsecurity.model.response;

import com.example.springsecurity.model.entity.PeopleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachResponse {

    private UUID id;
    private int inscricao;
    private PeopleEntity people;

}
