package com.ecommerce.ecommerce.application.service;

import com.ecommerce.ecommerce.domain.Product;
import com.ecommerce.ecommerce.domain.Stock;

import java.util.List;

public class ValidateStock {
    private final StockService stockService;

    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }

    //Creamos un metodo para ver si existe stock o no
    private boolean existBalance(Product product){
        //Hacemos una lista el cual nos devolvera toda la lista del producto
        // que viene como parametro
        List<Stock> stockList=stockService.getStockByProduct(product);
        //Aqui retornamos si es vacio false, si tiene productos true
        return  stockList.isEmpty() ? false: true;

    }

    public Stock calculateBalance(Stock stock){
        //Si es diferente de 0 quiere decir que va ingresar al stock del inventario
        if (stock.getUnitIn() !=0){
            //Si existe en metodo nos traera el stock del producto
            if (existBalance(stock.getProduct())){
                //Hacemos una lista del stock y traemos el stock
                List<Stock> stockList=stockService.getStockByProduct(stock.getProduct());
                //Creamos una variable para el balance y mediante el stockList.get que
                //permite traer un registro de acuerdo a la ubicacion que le pasemos
                //Buscamos el tamaño
                //con el getBanace traeriamos el saldo que esta en el inventario o ultimo registro
                Integer balance=stockList.get(stockList.size()-1).getBalance();
                //Ssteamos el nuevo valor de balance con el balance actual mas
                //el getUnitIn que seria el valor que estamos agregando
                stock.setBalance(balance + stock.getUnitIn());
            //Esto seria si no existe un inventario para el producto
            }else{
                //Como no hay producto solo seteamos el getUnitIn que viene a ser el incremeto
                stock.setBalance(stock.getUnitIn());
            }
        //Esto se haria por si hay una salida del producto o una venta
        }else{
            //Obtenemos todo el registro de inventario del producto
            List<Stock> stockList=stockService.getStockByProduct(stock.getProduct());
            //Obtenemos el ultimo saldo del producto, el ultimo valor que esta
            Integer balance=stockList.get(stockList.size()-1).getBalance();
            //Aqui al balance se le restaria y se restaria el getUnitOut que seria una compra
            stock.setBalance(balance - stock.getUnitOut());
        }

        return stock;
    }
}

