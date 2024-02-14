package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.application.service.StockService;
import com.ecommerce.ecommerce.application.service.ValidateStock;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/products/stock")
public class StockController {

    private final StockService stockService;
    private final ValidateStock validateStock;

    public StockController(StockService stockService, ValidateStock validateStock) {
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model){
        Product product=new Product();
        product.setId(id);
        List<Stock> stocks=stockService.getStockByProduct(product);
        model.addAttribute("stocks",stocks);
        model.addAttribute("idproduct",id);
        return "admin/stock/show";
    }

    @GetMapping("/create-unit-product/{id}")
    public String create(@PathVariable Long id,Model model){
        model.addAttribute("idproduct",id);
        return "/admin/stock/create";
    }

    @PostMapping("/save-unit-product")
    //El idproduct viene del formulario que es un nombre el cual identificaremos el id
    public String save(Stock stock, @RequestParam("idproduct") Long idproduct){
        //Seteamos los valores del stock
        stock.setDateCreated(LocalDateTime.now());
        stock.setDescription("inventario");

        //Creamos un producto el cual le asignaremos el id mandado por el formulario
        Product product=new Product();
        product.setId(idproduct);
        //Seteamos el producto en el stock
        stock.setProduct(product);
        //Aqui guardamos el stock, aqui gestionamos la validacion de la gestion de inventario
        //que se encuentra en validateStock el cual tiene el parametro calculateBalance el
        //cual nos devuelve el stock
        stockService.saveStock(validateStock.calculateBalance(stock));


        return "redirect:/admin/products/show";
    }

}
