package com.inspt.Veterinaria.Service;

import com.inspt.Veterinaria.Entity.Animal;
import com.inspt.Veterinaria.Repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }
    public Optional<Animal> findById(int id){
        return this.animalRepository.findById(id);
    }
    public List<Animal> findAll(){
        return this.animalRepository.findAll();
    }
    public Animal save(Animal animal){
        return this.animalRepository.save(animal);
    }
    public void delete(Animal animal){
        this.animalRepository.delete(animal);
    }
}
