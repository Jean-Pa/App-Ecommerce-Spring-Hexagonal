package com.ecommerce.ecommerce.infrastructure.mapper;

import com.ecommerce.ecommerce.domain.OrderProduct;
import com.ecommerce.ecommerce.infrastructure.entity.OrderProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spirng", uses = {ProductMapper.class, OrderProductMapper.class})
public interface OrderProductMapper {

    @Mappings(
            {
                    //Con el pk ingresamos al objeto y buscamos cual estamos asigando para cambiar
                    @Mapping(source = "pk.productEntity",target = "product"),
                    @Mapping(source = "quatity",target = "quatity"),
                    @Mapping(source = "pk.orderEntity",target = "order"),
            }
    )
    OrderProduct toOrderProduct(OrderProductEntity orderProductEntity);
    Iterable<OrderProduct> toOrderProducts(Iterable<OrderProductEntity> orderProductEntities);
    List<OrderProduct> toOrderProductsList(Iterable<OrderProductEntity> orderProductEntities);

    @InheritInverseConfiguration
    OrderProductEntity toOrderProductEntity(OrderProduct orderProduct);
}
