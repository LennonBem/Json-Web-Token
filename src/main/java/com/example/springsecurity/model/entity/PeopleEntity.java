
package com.example.springsecurity.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PEOPLE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PeopleEntity implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;
    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "CPF", unique = true,  length = 11)
    private Long cpf ;
    @NotNull
    @Column(name = "AGE")
    private int age ;
    @NotNull
    @Column(name = "CEL", unique = true)
    private Long cel ;
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private AddressEntity address ;





}