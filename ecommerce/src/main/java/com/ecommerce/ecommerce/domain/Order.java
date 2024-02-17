package com.ecommerce.ecommerce.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Long id;
    private LocalDateTime dateCreated;
    private List<OrderProduct> orderProducts;
    private User user;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //Creamos un metodo donde tendremos todas las ordenes de los productos del usuario
    //Iteramos una lista de orderProducts y setemos el valor a OrderProducts
    //Para asi pasar por parametro las ordenes
    public void addOrdersProduct(List<OrderProduct> orderProducts){
        this.setOrderProducts(orderProducts);
    }

    //Este metodo nos va servir para sumar todos los productos que tenemos en la orden
    //del carrito
    public BigDecimal getTotalOrderPrice(){
        //iteramos mediante stream
        return getOrderProducts().stream().map(
                //ponemos un alias p y sacamos el precio
                //que ya habiamos traido de la funcion orderProducts

                p->p.getTotalPrice()
                //Asignamos dos valores el cual BigDecimal.ZERO nos ayuda a que
                //los valores esten en cero y el BigDecimal::add añade los siguientes
                //valores, como estamos sacando el precio lo añade el precio total de
                //cada producto del carrito
        ).reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
