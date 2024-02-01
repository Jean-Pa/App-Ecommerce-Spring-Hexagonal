package com.ecommerce.ecommerce.infrastructure.adapter;



import com.ecommerce.ecommerce.infrastructure.entity.ProductEntity;
import com.ecommerce.ecommerce.infrastructure.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity,Long> {
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);
}
