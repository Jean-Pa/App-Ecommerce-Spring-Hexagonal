package com.ecommerce.ecommerce.infrastructure.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ordersproducts")

public class OrderProductEntity {
    @EmbeddedId
    private OrderProductPK pk;
    private Integer quantity;

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }

    public Integer getQuatity() {
        return quantity;
    }

    public void setQuatity(Integer quatity) {
        this.quantity = quatity;
    }
}
