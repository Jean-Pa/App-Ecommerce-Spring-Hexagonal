package com.ecommerce.ecommerce.application.service;

import com.ecommerce.ecommerce.domain.User;

public class RegistrationService {

    //Esta interfaz tiene todos los metodos para hacer CRUD con la tabla usuarios
    private final UserService userService;

    public RegistrationService(UserService userService) {
        this.userService = userService;
    }

    public void register(User user){
        userService.createUser(user);
    }
}
