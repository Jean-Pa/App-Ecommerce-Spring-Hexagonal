package com.ecommerce.ecommerce.application.repository;

import com.ecommerce.ecommerce.domain.Order;

public interface OrderRepository {
    public Order createOrder(Order order);
    public Iterable<Order> getOrders();
}
