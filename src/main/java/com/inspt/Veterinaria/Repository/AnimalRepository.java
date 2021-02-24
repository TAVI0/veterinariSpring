package com.inspt.Veterinaria.Repository;

import com.inspt.Veterinaria.Entity.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    Optional<Animal> findById(int id);
    List<Animal> findAll();
    Animal save(Animal animal);
    void deleteById(int id);

}
