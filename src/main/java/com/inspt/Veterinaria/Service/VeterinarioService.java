package com.inspt.Veterinaria.Service;

import com.inspt.Veterinaria.Entity.VetDays;
import com.inspt.Veterinaria.Repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {
    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioService(VeterinarioRepository veterinarioRepository){
        this.veterinarioRepository = veterinarioRepository;
    }

    public Optional<VetDays> findById(int id){
        return this.veterinarioRepository.findById(id);
    }
    public List<VetDays> findAll(){
        return this.veterinarioRepository.findAll();
    }
    public VetDays save(VetDays vetDays){
        return this.veterinarioRepository.save(vetDays);
    }
    public void delete(VetDays vetDays){
        this.veterinarioRepository.delete(vetDays);
    }
}
