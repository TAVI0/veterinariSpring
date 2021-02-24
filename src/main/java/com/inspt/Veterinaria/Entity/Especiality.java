package com.inspt.Veterinaria.Entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "especiality")
public class Especiality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="id_vet")
    private Integer idVet;
    private String especialidad;


}
