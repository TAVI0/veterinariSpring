package com.inspt.Veterinaria.Repository;

import com.inspt.Veterinaria.Entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    Optional<Producto> findById(int id);
    List<Producto> findAll();
    List<Producto> findByRegular(boolean regular);
    Producto save(Producto producto);
    void deleteById(int id);

}
