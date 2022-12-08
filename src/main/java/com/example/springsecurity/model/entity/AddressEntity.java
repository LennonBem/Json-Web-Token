package com.example.springsecurity.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name ="ADDRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity implements Serializable {

    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private UUID id;
    @NotNull(message = "Rua é obrigatório")
    @Column(name = "STREET")
    private String street;
    @NotNull(message = "Cidade é obrigatório")
    @Column(name = "CITY")
    private String city;
    @NotNull(message = "País é obrigatório")
    @Column(name = "COUNTRY")
    private String country;
    @NotNull(message = "CEP é obrigatório")
    @Column(name = "ZIP_CODE")
    private Long zipCode;


}
