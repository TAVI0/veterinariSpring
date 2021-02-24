package com.inspt.Veterinaria.Resources.Controllers;

import com.inspt.Veterinaria.Service.ProductoService;
import com.inspt.Veterinaria.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdminController {

    private final ProductoService productoService;
    private final UserService userService;

    public AdminController(UserService userService,ProductoService productoService) {
        this.userService = userService;
        this.productoService = productoService;
    }

    @GetMapping("/producto")
    public String getProductoPages(Model model){
        model.addAttribute("list", productoService.findAll());
        return "productosLista";
    }

    @GetMapping("/empleados")
    public String getEmpleadosPages(Model model){
        model.addAttribute("list", userService.findAll());
        return "usersLista";
    }


}
