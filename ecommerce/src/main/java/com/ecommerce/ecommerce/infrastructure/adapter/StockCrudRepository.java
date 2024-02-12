package com.ecommerce.ecommerce.infrastructure.adapter;

import com.ecommerce.ecommerce.infrastructure.entity.ProductEntity;
import com.ecommerce.ecommerce.infrastructure.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockCrudRepository extends CrudRepository<StockEntity,Long> {

    List<StockEntity> findByProductEntity(ProductEntity productEntity);
}
