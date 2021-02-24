package com.inspt.Veterinaria.Resources.Controllers;

import com.inspt.Veterinaria.Entity.Producto;
import com.inspt.Veterinaria.Service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductosController {

    private final ProductoService productoService;

    public ProductosController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listaProductos")
    public String productoPages(Model model){
        model.addAttribute("list", productoService.findAll());
        return "productosLista";
    }


    @GetMapping("/productosSave/{id}")
    public String showSave(@PathVariable("id") int id , Model model) {
        if(id != 0) {
            model.addAttribute("producto", productoService.findById(id) );
        }else {
            model.addAttribute("producto", new Producto());
        }
        return "productosSave";
    }
    @PostMapping("/productosSave")
    public String saveProducto(Producto producto,Model model){
        productoService.save(producto);

        model.addAttribute("list", productoService.findAll());
        return "productosLista";
    }
    @GetMapping("/deleteProducto/{id}")
    public String deleteProducto(@PathVariable int id, Model model){
        productoService.deleteById(id);

        model.addAttribute("list", productoService.findAll());
        return "productosLista";
    }



}
