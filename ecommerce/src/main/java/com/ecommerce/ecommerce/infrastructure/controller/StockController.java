package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/products/stock")
public class StockController {

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){
//        Product product
        return "admin/stock/show";
    }
}
