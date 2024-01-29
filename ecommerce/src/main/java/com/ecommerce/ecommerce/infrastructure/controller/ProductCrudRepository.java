package com.ecommerce.ecommerce.infrastructure.controller;


import com.ecommerce.ecommerce.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<ProductEntity,Long> {
}
