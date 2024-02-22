package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.application.service.RegistrationService;
import com.ecommerce.ecommerce.domain.User;
import com.ecommerce.ecommerce.domain.UserType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping
    public String register(){
        return "register";
    }


    @PostMapping
    public String registerUser(User user){
        user.setDateCreated(LocalDateTime.now());
        user.setUserType(UserType.USER);
        user.setUsername(user.getEmail());
        registrationService.register(user);
        return "redirect:/register";

    }
}
