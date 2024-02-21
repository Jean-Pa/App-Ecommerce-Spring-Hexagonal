package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.application.service.CartService;
import com.ecommerce.ecommerce.application.service.UserService;
import com.ecommerce.ecommerce.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/order")
public class OrderController {

    private final CartService cartService;
    private final UserService userService;

    public OrderController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model){
        User user=userService.findById(1L);
        //Enviamos los items del carrito
        model.addAttribute("cart",cartService.getItemCarts());
        //Enviamos el total del carrito
        model.addAttribute("total",cartService.getTotalCart());
        //Y por ultimo enviamos al usuario
        model.addAttribute("user",user);
        return "user/sumaryorder";
    }
}
