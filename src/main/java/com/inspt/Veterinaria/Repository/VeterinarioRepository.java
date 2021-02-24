package com.inspt.Veterinaria.Repository;

import com.inspt.Veterinaria.Entity.VetDays;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VeterinarioRepository extends CrudRepository<VetDays, Integer> {
    Optional<VetDays> findById(int id);
    List<VetDays> findAll();
    VetDays save(VetDays vetDays);
    void delete(VetDays vetDays);

}
