package com.ecommerce.ecommerce.infrastructure.mapper;

import com.ecommerce.ecommerce.domain.Stock;
import com.ecommerce.ecommerce.infrastructure.entity.StockEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-18T19:21:38-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class StockmapperImpl implements Stockmapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Stock toStock(StockEntity stockEntity) {
        if ( stockEntity == null ) {
            return null;
        }

        Stock stock = new Stock();

        stock.setId( stockEntity.getId() );
        stock.setDateCreated( stockEntity.getDateCreated() );
        stock.setUnitIn( stockEntity.getUnitIn() );
        stock.setUnitOut( stockEntity.getUnitOut() );
        stock.setDescription( stockEntity.getDescription() );
        stock.setBalance( stockEntity.getBalance() );
        stock.setProduct( productMapper.toProduct( stockEntity.getProductEntity() ) );

        return stock;
    }

    @Override
    public List<Stock> toStocks(List<StockEntity> stockEntities) {
        if ( stockEntities == null ) {
            return null;
        }

        List<Stock> list = new ArrayList<Stock>( stockEntities.size() );
        for ( StockEntity stockEntity : stockEntities ) {
            list.add( toStock( stockEntity ) );
        }

        return list;
    }

    @Override
    public StockEntity toStockEntity(Stock stock) {
        if ( stock == null ) {
            return null;
        }

        StockEntity stockEntity = new StockEntity();

        stockEntity.setId( stock.getId() );
        stockEntity.setDateCreated( stock.getDateCreated() );
        stockEntity.setUnitIn( stock.getUnitIn() );
        stockEntity.setUnitOut( stock.getUnitOut() );
        stockEntity.setDescription( stock.getDescription() );
        stockEntity.setBalance( stock.getBalance() );
        stockEntity.setProductEntity( productMapper.toProductEntity( stock.getProduct() ) );

        return stockEntity;
    }
}
