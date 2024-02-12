package com.ecommerce.ecommerce.application.repository;

import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.Stock;

import java.util.List;

public interface StockRepository {

    Stock saveStock(Stock stock);
    List<Stock> getStockByProduct(Product product);
}
