package com.ecommerce.ecommerce.infrastructure.controller;


import com.ecommerce.ecommerce.application.service.ProductService;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.User;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private  final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home(Model model){
        User user = new User();
        user.setId(1L);
        Iterable<Product> products= productService.getProductByUser(user);
        model.addAttribute("products",products);
        return "admin/home";
    }
}
