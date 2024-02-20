package com.ecommerce.ecommerce.infrastructure.configuration;

import com.ecommerce.ecommerce.application.repository.OrderProductRepository;
import com.ecommerce.ecommerce.application.repository.OrderRepository;
import com.ecommerce.ecommerce.application.repository.ProductRepository;
import com.ecommerce.ecommerce.application.repository.StockRepository;
import com.ecommerce.ecommerce.application.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;


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
   @Bean
    public OrderProductService orderProductService(OrderProductRepository orderProductRepository){
        return new OrderProductService(orderProductRepository);
   }

   @Bean
   //Se hace un scope para desabilitar el patron singleton que es por defecto en spring
   //ya que sino todo los usuarios tendrian el mismo carrito de compras
   @Scope(value = WebApplicationContext.SCOPE_SESSION,proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CartService cartService(){
        return new CartService();
   }
}
