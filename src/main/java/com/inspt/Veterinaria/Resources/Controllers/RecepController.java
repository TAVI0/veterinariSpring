package com.inspt.Veterinaria.Resources.Controllers;

import com.inspt.Veterinaria.Entity.Animal;
import com.inspt.Veterinaria.Entity.Producto;
import com.inspt.Veterinaria.Entity.User;
import com.inspt.Veterinaria.Repository.AnimalRepository;
import com.inspt.Veterinaria.Service.AnimalService;
import com.inspt.Veterinaria.Service.ProductoService;
import com.inspt.Veterinaria.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class RecepController {

    private final ProductoService productoService;
    private final AnimalService animalService;

    public RecepController(ProductoService productoService, AnimalService animalService) {
        this.productoService = productoService;
        this.animalService = animalService;
    }
// Lista de ventas de productos
    @GetMapping("/productoRegular")
    public String getProductoPages(Model model){
        model.addAttribute("list", productoService.findByRegular(true));
        return "productosListaVenta";
    }

    /////////////////////////////////////////////////////
//Lista de animales
    @GetMapping("/listaAnim")
    public String regAnim(Model model){
        model.addAttribute("list", animalService.findAll());
        return "animalLista";
    }
//imputs para agregar animales
    @GetMapping("/animalSave/{id}")
    public String showSave(@PathVariable("id") int id , Model model) {
        if(id != 0) {
            model.addAttribute("animal", animalService.findById(id) );
        }else {
            model.addAttribute("animal", new Animal());
        }
        return "animalSave";
    }
// funcion que guarda animales
    @PostMapping("/animalSave")
    public String saveUser(Animal animal,Model model){
        animalService.save(animal);

        model.addAttribute("list", animalService.findAll());
        return "animalLista";
    }
// borra un animal
    @GetMapping("/deleteAnimal/{id}")
    public String deleteEmpleado(@PathVariable int id, Model model){
        animalService.deleteById(id);

        model.addAttribute("list", animalService.findAll());
        return "animalLista";
    }
}
