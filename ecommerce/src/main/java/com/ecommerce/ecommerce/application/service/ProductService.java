package com.ecommerce.ecommerce.application.service;

import com.ecommerce.ecommerce.application.repository.ProductRepository;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.User;

import java.time.LocalDateTime;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Iterable<Product> getProduct(){

        return repository.getProducts();
    }

    public Iterable<Product> getProductByUser(User user){

        return repository.getProductsByUser(user);
    }

    public Product getProductById(Long id){

        return repository.getProductById(id);
    }

    public Product saveProduct(Product product){
        if(product.getId() == null){
            User user=new User();
            user.setId(1L);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(user);
            return repository.saveProduct(product);
        }else{
            Product productDB= repository.getProductById(product.getId());
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());
            product.setDateCreated(productDB.getDateCreated());
            product.setDateUpdated(LocalDateTime.now());
            return repository.saveProduct(product);
        }

    }

    public void deleteProductById(Long id){
        repository.deleteProductById(id);
    }


}
