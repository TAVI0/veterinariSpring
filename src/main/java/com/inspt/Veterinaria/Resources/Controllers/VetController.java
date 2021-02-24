package com.inspt.Veterinaria.Resources.Controllers;

import com.inspt.Veterinaria.Entity.Producto;
import com.inspt.Veterinaria.Service.ProductoService;
import com.inspt.Veterinaria.Service.UserService;
import com.inspt.Veterinaria.Service.VeterinarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class VetController {

    private final ProductoService productoService;
    private final VeterinarioService veterinarioService;

    public VetController(VeterinarioService veterinarioService, ProductoService productoService) {
        this.veterinarioService = veterinarioService;
        this.productoService = productoService;
    }

// lista de productos para la venta
    @GetMapping("/productoVentas")
    public String getProducto(Model model){
        model.addAttribute("list", productoService.findAll());
        return "productosListaVenta";
    }
    /////////////////////////////////////////

    //modifica los dias de trabajo



}
