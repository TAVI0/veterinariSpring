package com.inspt.Veterinaria.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data

@Embeddable
public class TurnPK implements Serializable {

    @Column(name = "id_vet")
    private Integer idVet;

    @Column(name = "id_anim")
    private Integer idAnim;
}
