package com.ecommerce.ecommerce.application.repository;

import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.User;

public interface ProductRepository {

    Iterable<Product> getProducts();
    Iterable<Product> getProductsByUser(User user);

    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProductById(Long id);
}
