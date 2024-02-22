package com.ecommerce.ecommerce.infrastructure.controller;

import com.ecommerce.ecommerce.application.service.*;
import com.ecommerce.ecommerce.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/order")
@Slf4j
public class OrderController {

    private final CartService cartService;
    private final UserService userService;

    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final StockService stockService;
    private final ValidateStock validateStock;

    public OrderController(CartService cartService, UserService userService, ProductService productService, OrderService orderService, OrderProductService orderProductService, StockService stockService, ValidateStock validateStock) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model){
        User user=userService.findById(1L);
        //Enviamos los items del carrito
        model.addAttribute("cart",cartService.getItemCarts());
        //Enviamos el total del carrito
        model.addAttribute("total",cartService.getTotalCart());
        //Y por ultimo enviamos al usuario
        model.addAttribute("user",user);
        return "user/sumaryorder";
    }

    @GetMapping("/create-order")
    public String createOrder(){
        log.info("create order..");
        //obtener un usuario temporal
        User user =userService.findById(1L);

        //Orden
        Order order=new Order();
        order.setDateCreated(LocalDateTime.now());
        order.setUser(user);

        order = orderService.createOrder(order);

        //Order product

        List<OrderProduct> orderProducts=new ArrayList<>();

        //Pasando de itemCart a orderProduct

        for(ItemCart itemCart:cartService.getItemCarts()){
            //Añadimos un producto mediante el new OrderPrdocut pasandole el producto, la cantidad y la orden
            //con con el product service buscamos el id que viene del itemCart, luego la cantidad, y la orden ya creada
            orderProducts.add(new OrderProduct(productService.getProductById(itemCart.getIdProduct()),itemCart.getQuantity(),order));
        }

        //Guardar

        orderProducts.forEach(
                //pasamos la variable op de orderProducts
                op->{
                    //Mediante esto lo guardamos ya que op es el objeto que se recorre
                    //mediante el forEach que viene de la lista de orderProducts
                    orderProductService.create(op);

                    //Necesitamos actualizar el inventario
                    //Para instanciamos el stock y seteamos los valores tiendo mediante
                    //op el valor que sale del stock
                    Stock stock=new Stock();
                    stock.setDateCreated(LocalDateTime.now());
                    stock.setProduct(op.getProduct());
                    stock.setDescription("Por venta");
                    //Seteamo la entrada en 0 para que no nos de error
                    stock.setUnitIn(0);
                    //Aqui op traeria la cantidad de salida de producto
                    stock.setUnitOut(op.getQuantity() );

                    //Con esto guardamos el stock pero con validateStock calculamos
                    //cuantos productos van quedando despues de la compra
                    stockService.saveStock(validateStock.calculateBalance(stock));
                }
        );
        //Este metodo nos permite vaciar el carrito
        cartService.removeAllItemsCart();
        return "redirect:/home";
    }
}
