package com.ecommerce.ecommerce.infrastructure.configuration;

import com.ecommerce.ecommerce.application.repository.OrderRepository;
import com.ecommerce.ecommerce.application.repository.ProductRepository;
import com.ecommerce.ecommerce.application.repository.StockRepository;
import com.ecommerce.ecommerce.application.service.*;
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

    @Bean
    public StockService stockService(StockRepository stockRepository){
        return new StockService(stockRepository);
   }

   @Bean
    public ValidateStock validateStock(StockService stockService){
        return new ValidateStock(stockService);
   }

   @Bean
    public OrderService orderService(OrderRepository orderRepository){
        return new OrderService(orderRepository);
   }
}
