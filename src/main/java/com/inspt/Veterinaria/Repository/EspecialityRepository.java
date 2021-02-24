package com.inspt.Veterinaria.Repository;

import com.inspt.Veterinaria.Entity.Especiality;
import com.inspt.Veterinaria.Entity.Producto;
import com.inspt.Veterinaria.Entity.Turn;
import com.inspt.Veterinaria.Entity.TurnPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EspecialityRepository extends CrudRepository<Especiality, Integer> {
    Optional<Especiality> findById(int id);
    List<Especiality> findAll();
    Especiality save(Especiality especiality);
    List<Especiality> findByIdVet(int idVet);
    void delete(Especiality especiality);

}
