package com.ecommerce.ecommerce.infrastructure.controller;


import com.ecommerce.ecommerce.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/products")
@Slf4j
public class ProductController {


    @GetMapping("/create")
    public String create(){

        return "admin/products/create";
    }

    @PostMapping("/save-product")
    public String saveProduct(Product product){
        return "admin/products/create";
    }
}
