package com.example.springsecurity.model.response;

import com.example.springsecurity.model.entity.AddressEntity;
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
public class PeopleResponse {

    private UUID id;

    private String name;

    private Long cpf ;

    private int age ;

    private Long cel ;

    private AddressEntity address ;
}
