package com.inspt.Veterinaria.Service;

import com.inspt.Veterinaria.Entity.Especiality;
import com.inspt.Veterinaria.Entity.Turn;
import com.inspt.Veterinaria.Repository.EspecialityRepository;
import com.inspt.Veterinaria.Repository.TurnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialityService {
    private final EspecialityRepository especialityRepository;

    public EspecialityService(EspecialityRepository especialityRepository){
        this.especialityRepository = especialityRepository;
    }

    public Optional<Especiality> findById(int id){
        return this.especialityRepository.findById(id);
    }
    public List<Especiality> findAll(){
        return this.especialityRepository.findAll();
    }
    public List<Especiality> findByIdVet(int idVet){ return this.especialityRepository.findByIdVet(idVet);}
    public Especiality save(Especiality especiality){
        return this.especialityRepository.save(especiality);
    }
    public void delete(Especiality especiality){
        this.especialityRepository.delete(especiality);
    }
}
