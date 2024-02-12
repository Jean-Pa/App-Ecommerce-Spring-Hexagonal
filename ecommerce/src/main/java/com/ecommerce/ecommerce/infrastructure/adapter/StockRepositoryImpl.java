package com.ecommerce.ecommerce.infrastructure.adapter;

import com.ecommerce.ecommerce.application.repository.StockRepository;
import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.Stock;
import com.ecommerce.ecommerce.infrastructure.mapper.ProductMapper;
import com.ecommerce.ecommerce.infrastructure.mapper.Stockmapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRepositoryImpl implements StockRepository {

    private final StockCrudRepository stockCrudRepository;
    private final Stockmapper stockmapper;
    private final ProductMapper productMapper;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository, Stockmapper stockmapper, ProductMapper productMapper) {
        this.stockCrudRepository = stockCrudRepository;
        this.stockmapper = stockmapper;
        this.productMapper = productMapper;
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockmapper.toStock(stockCrudRepository.save(stockmapper.toStockEntity(stock)));
    }

    @Override
    public List<Stock> getStockByProduct(Product product) {
        return stockmapper.toStocks(stockCrudRepository.findByProductEntity(productMapper.toProductEntity(product)));
    }
}
