package com.inspt.Veterinaria.Repository;

import com.inspt.Veterinaria.Entity.Turn;
import com.inspt.Veterinaria.Entity.TurnPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TurnRepository extends CrudRepository<Turn, TurnPK> {
    Optional<Turn> findById(int id);
    List<Turn> findAll();
    Turn save(Turn turn);
    void delete(Turn turn);

}
