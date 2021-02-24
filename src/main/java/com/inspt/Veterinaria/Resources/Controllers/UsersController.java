package com.inspt.Veterinaria.Resources.Controllers;

import com.inspt.Veterinaria.Entity.User;
import com.inspt.Veterinaria.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/listaUsers")
    public String UserPages(Model model){
        model.addAttribute("list", userService.findAll());
        return "usersLista";
    }


    @GetMapping("/userSave/{id}")
    public String showSave(@PathVariable("id") int id , Model model) {
        if(id != 0) {
            model.addAttribute("user", userService.findById(id) );
        }else {
            model.addAttribute("user", new User());
        }
        return "userSave";
    }

    @PostMapping("/userSave")
    public String saveUser(User user,Model model){
        userService.save(user);

        model.addAttribute("list", userService.findAll());
        return "usersLista";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteEmpleado(@PathVariable int id, Model model){
        userService.deleteById(id);

        model.addAttribute("list", userService.findAll());
        return "usersLista";
    }



}
