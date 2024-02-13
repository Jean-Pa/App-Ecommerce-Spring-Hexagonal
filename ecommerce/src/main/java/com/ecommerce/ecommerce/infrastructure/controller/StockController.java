package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.application.service.StockService;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/products/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){
        Product product=new Product();
        product.setId(id);
        List<Stock> stocks=stockService.getStockByProduct(product);
        model.addAttribute("stock",stocks);
        model.addAttribute("idproduct",id);
        return "admin/stock/show";
    }

    @GetMapping("/create-unit-product/{id}")
    public String create(@PathVariable Long id,Model model){
        model.addAttribute("idproduct",id);
        return "/admin/stock/create";
    }
}
