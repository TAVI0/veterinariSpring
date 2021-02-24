package com.inspt.Veterinaria.Entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "vet_days")
public class VetDays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vet")
    private Integer id;
/*
    @OneToOne
    @JoinColumn(name = "id_user",insertable = false, updatable = false)
    private User user;
*/
    @Column(name="day_1")
    private String day1;
    @Column(name="day_2")
    private String day2;
    @Column(name="day_3")
    private String day3;

}
