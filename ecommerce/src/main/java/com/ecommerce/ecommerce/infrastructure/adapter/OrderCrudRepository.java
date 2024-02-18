package com.ecommerce.ecommerce.infrastructure.adapter;

import com.ecommerce.ecommerce.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<OrderEntity,Long> {
}
