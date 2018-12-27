package org.timoshuk.computershop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.timoshuk.computershop.entity.order.Order;
import org.timoshuk.computershop.service.OrderService;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminOrderController {

    private final OrderService orderService;

    @Autowired
    public AdminOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "users/orders", method = RequestMethod.GET)
    public List<Order> showAllOrders(){
        return orderService.findAll();
    }

    @RequestMapping(value = "users/{id}/orders", method = RequestMethod.GET)
    public List<Order> showAllOrdersUserById(@PathVariable Long id){
        return orderService.findAllByUserId(id);
    }

    @RequestMapping(value = "/orders/{idOrder}", method = RequestMethod.GET)
    public Order showOrderById(@PathVariable("idOrder") Long idOrder){
        return orderService.findById(idOrder);
    }

    @RequestMapping(value = "/orders/status/{orderStatus}", method = RequestMethod.GET)
    public List<Order> showOrdersByOrderStatus(@PathVariable String orderStatus){
        return orderService.findAllByOrderStatus(orderStatus);
    }

    @RequestMapping(value = "/orders/{idOrder}/{orderStatus}", method = RequestMethod.PUT)
    public Order changeOrderStatus(@PathVariable Long idOrder,
                                   @PathVariable String orderStatus){
        Order order = orderService.findById(idOrder);
        orderService.changeOrder(order,orderStatus);
        orderService.update(order);
        return order;
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteById(id);
    }
}
