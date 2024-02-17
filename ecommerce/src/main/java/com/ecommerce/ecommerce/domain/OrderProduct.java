package com.ecommerce.ecommerce.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderProduct {
    //Para saber a que producto pertenece
    private Product product;

    //Para saber la cantidad
    private Integer quantity;

    //Para saber a que orden de pedido pertenece
    private Order order;

    public OrderProduct(Product product, Integer quantity, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }


    //Para calcular el total del producto, es decir el precio por la cantidad
    public BigDecimal getTotalPrice(){

        //Lo que hace este return es como product tiene un parametro bigDecimal
        //para el precio se puede multiplicar con la cantidad
        //convirtiendo esta cantidad en bigdecimal
        return this.product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
