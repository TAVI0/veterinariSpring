package com.inspt.Veterinaria.Entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_anim")
    private Integer id;

    private String name;
    private String type;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "contact_owner")
    private String contactOwner;

}
