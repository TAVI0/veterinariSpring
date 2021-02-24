package com.inspt.Veterinaria.Entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "veterinario")
public class VetDays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vet")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_user",insertable = false, updatable = false)
    private User user;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    @Column(name="dat_1")
    private String day1;
    @Column(name="dat_2")
    private String day2;
    @Column(name="dat_3")
    private String day3;

}
