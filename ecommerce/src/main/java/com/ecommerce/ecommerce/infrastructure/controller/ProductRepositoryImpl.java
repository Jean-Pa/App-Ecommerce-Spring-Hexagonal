package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.application.repository.ProductRepository;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.User;
import com.ecommerce.ecommerce.infrastructure.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductCrudRepository productCrudRepository;

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }


    @Override
    public Iterable<Product> getProducts() {
        return null;
    }

    @Override
    public Iterable<Product> getProductsByUser(User user) {
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }
}
