package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.application.service.ProductService;
import com.ecommerce.ecommerce.application.service.StockService;
import com.ecommerce.ecommerce.domain.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {

    private final ProductService productService;
    private final StockService stockService;

    public HomeController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }



    @GetMapping
    public String home(Model model){
        model.addAttribute("products",productService.getProduct());
        return "home";
    }

    @GetMapping("/product-detail/{id}")
    public String productDetail(@PathVariable Long id, Model model){
        List<Stock> stocks = stockService.getStockByProduct(productService.getProductById(id));

        Integer lastBalance = stocks.get(stocks.size()-1).getBalance();

        model.addAttribute("product", productService.getProductById(id));
       // model.addAttribute("stock",lastBalance);
        model.addAttribute("stock", lastBalance);


        return "user/productdetail";
    }
}
