package com.ecommerce.ecommerce.infrastructure.controller;


import com.ecommerce.ecommerce.application.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/user/cart")
@Slf4j
public class CartController {

     private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping("/add-product")
    public String addProductCart(@RequestParam Integer quantity, @RequestParam Long idProduct, @RequestParam String nameProduct, @RequestParam BigDecimal price){
        cartService.addItemCart(quantity,idProduct,nameProduct,price);
        //Este metodo nos sirve para ver el carrito de compras
        cartService.getItemCarts().forEach(
                itemCart->log.info("item cart: ",itemCart)
        );
        return "redirect:/home";
    }
}
