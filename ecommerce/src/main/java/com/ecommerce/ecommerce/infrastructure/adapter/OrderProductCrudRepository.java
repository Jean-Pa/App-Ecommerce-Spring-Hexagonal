package com.ecommerce.ecommerce.infrastructure.adapter;

import com.ecommerce.ecommerce.infrastructure.entity.OrderEntity;
import com.ecommerce.ecommerce.infrastructure.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderProductCrudRepository extends CrudRepository<OrderProductEntity,Long> {

    //Asignamos una busqueda por OrderEntity mediante un List
    List<OrderProductEntity> findByPkOrderEntity(OrderEntity orderEntity);
}
