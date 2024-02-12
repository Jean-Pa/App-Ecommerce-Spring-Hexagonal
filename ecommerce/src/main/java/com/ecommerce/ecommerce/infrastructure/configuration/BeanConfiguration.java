package com.ecommerce.ecommerce.infrastructure.configuration;

import com.ecommerce.ecommerce.application.repository.ProductRepository;
import com.ecommerce.ecommerce.application.repository.StockRepository;
import com.ecommerce.ecommerce.application.service.ProductService;
import com.ecommerce.ecommerce.application.service.StockService;
import com.ecommerce.ecommerce.application.service.UploadFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile){
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public UploadFile uploadFile(){
        return new UploadFile();
    }

//    @Bean
//    public StockService stockService(StockRepository stockRepository){
//        return new StockService(stockRepository);
//    }
}
