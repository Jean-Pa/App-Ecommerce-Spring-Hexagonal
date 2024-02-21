package com.ecommerce.ecommerce.infrastructure.controller;


import com.ecommerce.ecommerce.application.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        showCart();
        return "redirect:/home";
    }

    private void showCart() {
        cartService.getItemCarts().forEach(
                itemCart->log.info("item cart: ",itemCart)
        );
    }


    //En este metodo es que pasamos los productos o items al carrito
    //t luego tambien pasamos el precio total
    @GetMapping("/get-cart")
    public String getCart(Model model){
        showCart();

        model.addAttribute("cart",cartService.getItemCarts());
        model.addAttribute("total",cartService.getTotalCart());
        return "user/cart/cart";
    }

    //Este metodo es para eliminar un item del carrito por el id
    @GetMapping("/delete-item-cart/{id}")
    public String deleteItemCart(@PathVariable Long id){
        cartService.removeItemCart(id);
        return "redirect:/user/cart/get-cart";
    }


}
