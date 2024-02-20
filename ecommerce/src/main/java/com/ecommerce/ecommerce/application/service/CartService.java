package com.ecommerce.ecommerce.application.service;

import com.ecommerce.ecommerce.domain.ItemCart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartService {

    private List<ItemCart> itemCarts;

    //Lo hacemos para iterar y que los id no se repita ya que se pasara el id del producto
    //y luego el producto, con hashmap no se van a repetir los id, validamos que el usuario no ingrese productos repetidos
    private HashMap<Long,ItemCart> itemCartHashMap;

    public CartService() {
        this.itemCartHashMap=new HashMap<>();
        this.itemCarts=new ArrayList<>();
    }


    //Aqui añadimos productos al carrito de compras pasando todos los valores por parametros, creamos un nuevo ItemCart
    //y pasamos los valores de los parametros viendo que esten en orden de la entidad, y con esto hacemos un put al
    //itemCartHashMap para añadirlo le pasamos dos valores primero el id mediante el itemCart y luego el producto completo
    public void addItemCart(Integer quantity, Long idProduct, String nameProduct, BigDecimal price){
        ItemCart itemCart=new ItemCart(idProduct,nameProduct,quantity,price);
        itemCartHashMap.put(itemCart.getIdProduct(),itemCart);

        //Con esto hacemos una transformacion de hashMap a List
        fillList();
    }


    //Con esto hacemos sumar el valor de cada item o producto y retornar el total
    public BigDecimal getTotalCart(){
        BigDecimal total=BigDecimal.ZERO;

        for (ItemCart itemCart: itemCarts){
            total=total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }

    //Aqui removemos un producto de la lista de carrito
    //Para esto necesitamos el id del producto para asi mandarlo al
    //itemCartHashMap y con el remove pasamos el id del producto
    public void removeItemCart(Long idProduct){
        itemCartHashMap.remove(idProduct);
        //Con esto hacemos una transformacion de hashMap a List
        fillList();
    }

    //Este metodo es para quitar todos los productos del carrito
    //Con el metodo clear los eliminamos
    public void removeAllItemsCart(){
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    //En este metodo estariamos pasando de hashMap a List
    public void fillList(){
        itemCarts.clear();
        itemCartHashMap.forEach(
                (integer, itemCart)->itemCarts.add(itemCart)
        );
    }

    //Para mirar por consola
    public List<ItemCart> getItemCarts(){
        return itemCarts;
    }
}
