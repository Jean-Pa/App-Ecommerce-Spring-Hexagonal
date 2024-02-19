package com.ecommerce.ecommerce.infrastructure.mapper;

import com.ecommerce.ecommerce.domain.Order;
import com.ecommerce.ecommerce.domain.OrderProduct;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.User;
import com.ecommerce.ecommerce.infrastructure.entity.OrderEntity;
import com.ecommerce.ecommerce.infrastructure.entity.OrderProductEntity;
import com.ecommerce.ecommerce.infrastructure.entity.OrderProductPK;
import com.ecommerce.ecommerce.infrastructure.entity.ProductEntity;
import com.ecommerce.ecommerce.infrastructure.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-18T19:22:34-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class OrderProductMapperImpl implements OrderProductMapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public OrderProduct toOrderProduct(OrderProductEntity orderProductEntity) {
        if ( orderProductEntity == null ) {
            return null;
        }

        Product product = null;
        Integer quantity = null;
        Order order = null;

        product = productMapper.toProduct( orderProductEntityPkProductEntity( orderProductEntity ) );
        quantity = orderProductEntity.getQuantity();
        order = orderEntityToOrder( orderProductEntityPkOrderEntity( orderProductEntity ) );

        OrderProduct orderProduct = new OrderProduct( product, quantity, order );

        return orderProduct;
    }

    @Override
    public Iterable<OrderProduct> toOrderProducts(Iterable<OrderProductEntity> orderProductEntities) {
        if ( orderProductEntities == null ) {
            return null;
        }

        ArrayList<OrderProduct> iterable = new ArrayList<OrderProduct>();
        for ( OrderProductEntity orderProductEntity : orderProductEntities ) {
            iterable.add( toOrderProduct( orderProductEntity ) );
        }

        return iterable;
    }

    @Override
    public List<OrderProduct> toOrderProductsList(Iterable<OrderProductEntity> orderProductEntities) {
        if ( orderProductEntities == null ) {
            return null;
        }

        List<OrderProduct> list = new ArrayList<OrderProduct>();
        for ( OrderProductEntity orderProductEntity : orderProductEntities ) {
            list.add( toOrderProduct( orderProductEntity ) );
        }

        return list;
    }

    @Override
    public OrderProductEntity toOrderProductEntity(OrderProduct orderProduct) {
        if ( orderProduct == null ) {
            return null;
        }

        OrderProductEntity orderProductEntity = new OrderProductEntity();

        orderProductEntity.setPk( orderProductToOrderProductPK( orderProduct ) );
        orderProductEntity.setQuantity( orderProduct.getQuantity() );

        return orderProductEntity;
    }

    private ProductEntity orderProductEntityPkProductEntity(OrderProductEntity orderProductEntity) {
        if ( orderProductEntity == null ) {
            return null;
        }
        OrderProductPK pk = orderProductEntity.getPk();
        if ( pk == null ) {
            return null;
        }
        ProductEntity productEntity = pk.getProductEntity();
        if ( productEntity == null ) {
            return null;
        }
        return productEntity;
    }

    private OrderEntity orderProductEntityPkOrderEntity(OrderProductEntity orderProductEntity) {
        if ( orderProductEntity == null ) {
            return null;
        }
        OrderProductPK pk = orderProductEntity.getPk();
        if ( pk == null ) {
            return null;
        }
        OrderEntity orderEntity = pk.getOrderEntity();
        if ( orderEntity == null ) {
            return null;
        }
        return orderEntity;
    }

    protected User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setUsername( userEntity.getUsername() );
        user.setFirstName( userEntity.getFirstName() );
        user.setLastName( userEntity.getLastName() );
        user.setEmail( userEntity.getEmail() );
        user.setAddress( userEntity.getAddress() );
        user.setCellphone( userEntity.getCellphone() );
        user.setPassword( userEntity.getPassword() );
        user.setUserType( userEntity.getUserType() );
        user.setDateCreated( userEntity.getDateCreated() );

        return user;
    }

    protected Order orderEntityToOrder(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderEntity.getId() );
        order.setDateCreated( orderEntity.getDateCreated() );
        order.setUser( userEntityToUser( orderEntity.getUser() ) );

        return order;
    }

    protected UserEntity userToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setUsername( user.getUsername() );
        userEntity.setFirstName( user.getFirstName() );
        userEntity.setLastName( user.getLastName() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setAddress( user.getAddress() );
        userEntity.setCellphone( user.getCellphone() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setUserType( user.getUserType() );
        userEntity.setDateCreated( user.getDateCreated() );

        return userEntity;
    }

    protected OrderEntity orderToOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setId( order.getId() );
        orderEntity.setDateCreated( order.getDateCreated() );
        orderEntity.setUser( userToUserEntity( order.getUser() ) );

        return orderEntity;
    }

    protected OrderProductPK orderProductToOrderProductPK(OrderProduct orderProduct) {
        if ( orderProduct == null ) {
            return null;
        }

        OrderProductPK orderProductPK = new OrderProductPK();

        orderProductPK.setProductEntity( productMapper.toProductEntity( orderProduct.getProduct() ) );
        orderProductPK.setOrderEntity( orderToOrderEntity( orderProduct.getOrder() ) );

        return orderProductPK;
    }
}
