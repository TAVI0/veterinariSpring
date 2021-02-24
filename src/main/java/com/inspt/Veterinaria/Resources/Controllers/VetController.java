package com.inspt.Veterinaria.Resources.Controllers;

import com.inspt.Veterinaria.Entity.Especiality;
import com.inspt.Veterinaria.Entity.Producto;
import com.inspt.Veterinaria.Entity.User;
import com.inspt.Veterinaria.Entity.VetDays;
import com.inspt.Veterinaria.Resources.VO.LoginVO;
import com.inspt.Veterinaria.Resources.VO.VentaVO;
import com.inspt.Veterinaria.Service.EspecialityService;
import com.inspt.Veterinaria.Service.ProductoService;
import com.inspt.Veterinaria.Service.UserService;
import com.inspt.Veterinaria.Service.VeterinarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class VetController {

    private final ProductoService productoService;
    private final VeterinarioService veterinarioService;
    private final EspecialityService especialityService;

    public VetController(VeterinarioService veterinarioService, ProductoService productoService, EspecialityService especialityService) {
        this.veterinarioService = veterinarioService;
        this.productoService = productoService;
        this.especialityService = especialityService;
    }

// lista de productos para la venta
    @GetMapping("/productoVentas")
    public String getProducto(Model model){
        model.addAttribute("list", productoService.findAll());
        model.addAttribute("ventaVO", new VentaVO());
        return "productosListaVentaFull";
    }

    @GetMapping("/productoVentaFull/{id}")
    public String venderProducto(@PathVariable("id")int id, @ModelAttribute("ventaVO") VentaVO ventaVO, Model model){
        Producto prod = productoService.findById(id).get();
        int sell = ventaVO.getVenta();
        int newStock = prod.getStock() - sell;

        prod.setStock(newStock);
        productoService.save(prod);

        model.addAttribute("list", productoService.findAll());
        return "productosListaVentaFull";
    }
    /////////////////////////////////////////

    //ver los dias de trabajo
    @GetMapping("/viewdiasTrabajo/{id}")
    public String vistadiasTrabajo(Model model,@PathVariable("id")int id) {

        VetDays user = veterinarioService.findById(id).get();

        model.addAttribute("vetDays", user);
        model.addAttribute("userBD", id);

        return "workDays";
    }


    //modifica los dias de trabajo
    @GetMapping("/workDaysSave/{id}")
    public String diasTrabajo(Model model,@PathVariable("id")int id) {

        if(id != 0) {
            model.addAttribute("vetDays", veterinarioService.findById(id));
        }else {
            model.addAttribute("vetDays", new VetDays());
        }

        return "workDaySave";
    }

    //guarda los dias de trabajo
    @PostMapping("/workDaysSave")
    public String diasTrabajo(Model model,VetDays vetDays) {
        veterinarioService.save(vetDays);
        model.addAttribute("userBD", vetDays.getId());
        return "workDays";
    }

    ////////////////////////////////
    //ver especialidad
    @GetMapping("/viewEspecialidad/{id}")
    public String especialidad(Model model,@PathVariable("id")int id){
        model.addAttribute("list", especialityService.findByIdVet(id));
        model.addAttribute("userBD", id);
        return "especialidadLista";
    }
    //formulario para agregar especialidad
    @GetMapping("/addEspecialidad/{id}")
    public String agregarEspecialidad(Model model,@PathVariable("id")int id){
        model.addAttribute("especiality",new Especiality());
        model.addAttribute("userBD",id);
        return "especialidadSave";
    }

    @PostMapping("/especialitySave{id}")
    public String guardarEspecialidad(Model model, Especiality especiality, @PathVariable("id")int id) {
        especiality.setIdVet(id);



        especialityService.save(especiality);
        model.addAttribute("userBD", especiality.getIdVet());
        model.addAttribute("list",especialityService.findByIdVet(id));
        return "especialidadLista";
    }


}
