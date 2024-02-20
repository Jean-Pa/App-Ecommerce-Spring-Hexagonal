package com.ecommerce.ecommerce.infrastructure.mapper;

import com.ecommerce.ecommerce.domain.Order;
import com.ecommerce.ecommerce.infrastructure.entity.OrderEntity;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-20T17:17:57-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Order toOrder(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderEntity.getId() );
        order.setDateCreated( orderEntity.getDateCreated() );
        order.setUser( userMapper.toUser( orderEntity.getUser() ) );

        return order;
    }

    @Override
    public Iterable<Order> toOrders(Iterable<OrderEntity> orderEntities) {
        if ( orderEntities == null ) {
            return null;
        }

        ArrayList<Order> iterable = new ArrayList<Order>();
        for ( OrderEntity orderEntity : orderEntities ) {
            iterable.add( toOrder( orderEntity ) );
        }

        return iterable;
    }

    @Override
    public OrderEntity toOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( order.getId() );
        orderEntity.setDateCreated( order.getDateCreated() );
        orderEntity.setUser( userMapper.toUserEntity( order.getUser() ) );

        return orderEntity;
    }
}
