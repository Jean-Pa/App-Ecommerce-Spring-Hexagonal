package com.ecommerce.ecommerce.application.service;

import com.ecommerce.ecommerce.application.repository.OrderProductRepository;
import com.ecommerce.ecommerce.domain.Order;
import com.ecommerce.ecommerce.domain.OrderProduct;

import java.util.List;

public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProduct create(OrderProduct orderProduct){
        return orderProductRepository.create(orderProduct);
    }

    public Iterable<OrderProduct> getOrderProducts(){
        return orderProductRepository.getOrderProducts();
    }

    public List<OrderProduct> getOrderProductByOrder(Order order){
        return orderProductRepository.getOrderProductByOrder(order);
    }


}
