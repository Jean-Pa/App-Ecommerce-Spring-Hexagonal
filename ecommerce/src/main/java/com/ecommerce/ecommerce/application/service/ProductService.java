package com.ecommerce.ecommerce.application.service;

import com.ecommerce.ecommerce.application.repository.ProductRepository;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

public class ProductService {
    private final ProductRepository repository;

    private final UploadFile uploadFile;

    public ProductService(ProductRepository repository, UploadFile uploadFile) {
        this.repository = repository;
        this.uploadFile = uploadFile;
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

    public Product saveProduct(Product product, MultipartFile multipartFile) throws IOException {
        if(product.getId() == null){
            User user=new User();
            user.setId(1L);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setImage(uploadFile.upload(multipartFile));
            product.setUser(user);
            return repository.saveProduct(product);
        }else{
            Product productDB= repository.getProductById(product.getId());
            //Si no se carga la imagen toma la que se guardo en el registro
            if(multipartFile.isEmpty()){
                //Le asignamos la misma imagen que tenia
                product.setImage(productDB.getImage());
            }else {
                //Guarda la imagen que se le envia actualmente
                //antes se elimina pero si no es por default.jpg
                if (!productDB.getImage().equals("default.jpg")){
                    uploadFile.delete(productDB.getImage());
                }
                product.setImage(uploadFile.upload(multipartFile));
            }
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
