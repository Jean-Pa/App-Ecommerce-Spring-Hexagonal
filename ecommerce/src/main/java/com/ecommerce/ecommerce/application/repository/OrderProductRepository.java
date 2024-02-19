package com.ecommerce.ecommerce.application.repository;

import com.ecommerce.ecommerce.domain.Order;
import com.ecommerce.ecommerce.domain.OrderProduct;

import java.util.List;

public interface OrderProductRepository {

    public OrderProduct create(OrderProduct orderProduct);
    public Iterable<OrderProduct> getOrderProducts();
    public List<OrderProduct> getOrderProductByOrder(Order order);
}
