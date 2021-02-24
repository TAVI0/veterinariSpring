package com.inspt.Veterinaria.Service;

import com.inspt.Veterinaria.Entity.Turn;
import com.inspt.Veterinaria.Repository.TurnRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnService {
    private final TurnRepository turnRepository;

    public TurnService(TurnRepository turnRepository){
        this.turnRepository = turnRepository;
    }

    public Optional<Turn> findById(int id){
        return this.turnRepository.findById(id);
    }
    public List<Turn> findAll(){
        return this.turnRepository.findAll();
    }
    public Turn save(Turn admin){
        return this.turnRepository.save(admin);
    }
    public void delete(Turn admin){
        this.turnRepository.delete(admin);
    }
}
