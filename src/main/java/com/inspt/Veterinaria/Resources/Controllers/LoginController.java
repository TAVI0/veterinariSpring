package com.inspt.Veterinaria.Resources.Controllers;

import com.inspt.Veterinaria.Entity.User;
import com.inspt.Veterinaria.Resources.VO.LoginVO;
import com.inspt.Veterinaria.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute(name = "loginVO") LoginVO loginVO , Model model){
        String user = loginVO.getUser();
        String password = loginVO.getPassword();

        Optional<User> possibleUser = userService.findByUserName(user);
        if(possibleUser.isPresent()){
            User userBD = possibleUser.get();
            if(userBD.getPassword().equals(password)){
                String type = userBD.getType();
                switch (type){
                    case "adm":
                        return "admin";
                    case "vet":
                        return "veterinario";
                    case "rec":
                        return "recepcionista";
                }
            }else{
                model.addAttribute("invalidCredential","password incorrecta");
                return "index";
            }
        }else{
            model.addAttribute("invalidCredential","usuario no encontrado");
            return "index";
        }
        return "index";
    }



}
