package com.inspt.Veterinaria.Service;

import com.inspt.Veterinaria.Entity.Producto;
import com.inspt.Veterinaria.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public Optional<Producto> findById(int id){
        return this.productoRepository.findById(id);
    }
    public List<Producto> findAll(){
        return this.productoRepository.findAll();
    }
    public Producto save(Producto producto){
        return this.productoRepository.save(producto);
    }
    public void deleteById(int id){
        this.productoRepository.deleteById(id);
    }
}
