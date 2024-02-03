package com.ecommerce.ecommerce.infrastructure.mapper;

import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.infrastructure.entity.ProductEntity;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-01T02:13:53-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Product toProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setCode( productEntity.getCode() );
        product.setName( productEntity.getName() );
        product.setDescription( productEntity.getDescription() );
        product.setImage( productEntity.getImage() );
        product.setPrice( productEntity.getPrice() );
        product.setDateCreated( productEntity.getDateCreated() );
        product.setDateUpdated( productEntity.getDateUpdated() );
        product.setUser( userMapper.toUser( productEntity.getUserEntity() ) );

        return product;
    }

    @Override
    public Iterable<Product> toProducts(Iterable<ProductEntity> productEntities) {
        if ( productEntities == null ) {
            return null;
        }

        ArrayList<Product> iterable = new ArrayList<Product>();
        for ( ProductEntity productEntity : productEntities ) {
            iterable.add( toProduct( productEntity ) );
        }

        return iterable;
    }

    @Override
    public ProductEntity toProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setCode( product.getCode() );
        productEntity.setName( product.getName() );
        productEntity.setDescription( product.getDescription() );
        productEntity.setImage( product.getImage() );
        productEntity.setPrice( product.getPrice() );
        productEntity.setDateCreated( product.getDateCreated() );
        productEntity.setDateUpdated( product.getDateUpdated() );
        productEntity.setUserEntity( userMapper.toUserEntity( product.getUser() ) );

        return productEntity;
    }
}
