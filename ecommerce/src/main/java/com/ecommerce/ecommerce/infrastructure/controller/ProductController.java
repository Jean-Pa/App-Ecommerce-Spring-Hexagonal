package com.ecommerce.ecommerce.infrastructure.controller;


import com.ecommerce.ecommerce.application.service.ProductService;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String showProduct(Model model){
        User user = new User();
        user.setId(1L);
        Iterable<Product> products= productService.getProductByUser(user);
        model.addAttribute("products",products);

        return "admin/products/show";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model){
        Product product=productService.getProductById(id);

        model.addAttribute("product",product);
        return "admin/products/edit";

    }
}
