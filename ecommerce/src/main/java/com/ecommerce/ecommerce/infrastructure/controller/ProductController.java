package com.ecommerce.ecommerce.infrastructure.controller;


import com.ecommerce.ecommerce.application.service.ProductService;
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

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/create")
    public String create(){

        return "admin/products/create";
    }

    @PostMapping("/save-product")
    public String saveProduct(Product product){
        productService.saveProduct(product);
       // return "admin/products/create";
        return "redirect:/admin";
    }

    @GetMapping("/show")
    public String showProduct(){

        return "admin/products/show";
    }
}
