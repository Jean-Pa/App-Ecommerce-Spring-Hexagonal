package com.ecommerce.ecommerce.infrastructure.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderProductPK {

    //ManyToOne porque una orden puede tener muchos detalles
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderEntity orderEntity;

    //ManyToOne el detalle de una orden puede tener muchos productos
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductEntity productEntity;

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
