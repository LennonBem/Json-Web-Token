package com.example.springsecurity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "COACH")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CoachEntity implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;


    @NotNull
    @Column(name = "N_INSCRICAO",unique = true)
    private int inscricao;


    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    private PeopleEntity people;

}
