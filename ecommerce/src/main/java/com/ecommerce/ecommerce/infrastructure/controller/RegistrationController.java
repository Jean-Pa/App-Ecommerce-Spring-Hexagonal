package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.application.service.RegistrationService;
import com.ecommerce.ecommerce.domain.User;
import com.ecommerce.ecommerce.domain.UserType;
import com.ecommerce.ecommerce.infrastructure.dto.UserDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/register")
@Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping
    public String register(){
        return "register";
    }


    //Con valid hace la validacion
    //Con BindingResult me puede decir si han ocurrido errores, osea que el usuario no
    //escribio los campos que validamos
    @PostMapping
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult){
//        user.setDateCreated(LocalDateTime.now());
//        user.setUserType(UserType.USER);
//        user.setUsername(user.getEmail());

        //Cuando hay un error retorna true
        if(bindingResult.hasErrors()){
            //Aqui traemos todo  y lo recorremos y vemos cual estuvo con error
            bindingResult.getAllErrors().forEach(
                    //con la variable e vemos todos los errores y en las llaves iteraria
                    e->{log.info("Errors {}",e.getDefaultMessage());}
            );
        }
        //Aqui pasamos el objeto de tipo usuario que ya lo estamos traendo del DTO
        registrationService.register(userDto.userDtoToUser());
        return "redirect:/register";

    }
}
