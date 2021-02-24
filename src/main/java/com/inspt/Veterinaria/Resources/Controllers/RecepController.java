package com.inspt.Veterinaria.Resources.Controllers;

import com.inspt.Veterinaria.Entity.Animal;
import com.inspt.Veterinaria.Entity.Producto;
import com.inspt.Veterinaria.Resources.VO.VentaVO;
import com.inspt.Veterinaria.Service.AnimalService;
import com.inspt.Veterinaria.Service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



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
        model.addAttribute("ventaVO", new VentaVO());
        return "productosListaVenta";
    }

    @GetMapping("/productoVenta/{id}")
    public String venderProducto(@PathVariable("id")int id, @ModelAttribute("ventaVO") VentaVO ventaVO, Model model){
        Producto prod = productoService.findById(id).get();
        int sell = ventaVO.getVenta();
        int newStock = prod.getStock() - sell;

        System.out.println("sell " + sell);
        System.out.println("stock " + newStock);

        prod.setStock(newStock);
        productoService.save(prod);


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
