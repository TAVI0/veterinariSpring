package com.inspt.Veterinaria.Entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Integer id;

    @Column(name = "user")
    private String userName;
    private String password;

    private String type; //adm, rec, vet

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;



}
