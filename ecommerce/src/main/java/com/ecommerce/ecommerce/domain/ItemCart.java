package com.ecommerce.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class ItemCart {
    private Long idProduct;
    private String nameProduct;
    private Integer quantity;
    private BigDecimal price;


    //Creamos un metodo donde sabremos el precio de cada item
    //ayudandonos con BigDecimal y el multiply pasamos la cantidad(quantity)
    public BigDecimal getTotalPriceItem(){
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
