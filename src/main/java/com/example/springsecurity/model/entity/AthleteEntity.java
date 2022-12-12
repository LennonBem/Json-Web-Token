package com.example.springsecurity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name ="ATHLETE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteEntity implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;

    @NotNull
    @Column(name = "N_INSCRICAO",unique = true)
    private int numInscricao;


    @NotNull
    @OneToOne
    private PeopleEntity people;
}
