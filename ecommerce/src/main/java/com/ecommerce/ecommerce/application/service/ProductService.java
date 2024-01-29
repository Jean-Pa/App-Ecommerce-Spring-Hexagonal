package com.ecommerce.ecommerce.application.service;

import com.ecommerce.ecommerce.application.repository.ProductRepository;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.User;

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
       return repository.saveProduct(product);

    }

    public void deleteProductById(Long id){
        repository.deleteProductById(id);
    }


}
