package com.inspt.Veterinaria.Entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "turn")
public class Turn {

    @EmbeddedId
    private TurnPK id;

    @ManyToOne
    @JoinColumn(name = "id_vet",insertable = false, updatable = false)
    private VetDays vetDays;

    @ManyToOne
    @JoinColumn(name = "id_anim",insertable = false, updatable = false)
    private Animal animal;
}