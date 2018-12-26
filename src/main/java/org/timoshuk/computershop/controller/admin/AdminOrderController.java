package org.timoshuk.computershop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.timoshuk.computershop.entity.order.Order;
import org.timoshuk.computershop.service.OrderService;
import org.timoshuk.computershop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users/orders", method = RequestMethod.GET)
    public List<Order> showAllOrders(){
        List<Order> orderList = orderService.findAll();
        return orderList;
    }

    @RequestMapping(value = "users/{id}/orders", method = RequestMethod.GET)
    public List<Order> showAllOrdersUserById(@PathVariable Long id){
        List<Order> orderList = orderService.findAllByUserId(id);
        return orderList;
    }

    @RequestMapping(value = "/orders/{idOrder}", method = RequestMethod.GET)
    public Order showOrderById(@PathVariable("idOrder") Long idOrder){
        Order order = orderService.findById(idOrder);
        return order;
    }

    @RequestMapping(value = "/orders/status/{orderStatus}", method = RequestMethod.GET)
    public List<Order> showOrdersByOrderStatus(@PathVariable String orderStatus){
        List<Order> orderList = orderService.findAllByOrderStatus(orderStatus);
        return orderList;
    }

    @RequestMapping(value = "/orders/{idOrder}/{orderStatus}", method = RequestMethod.PUT)
    public Order changeOrderStatus(@PathVariable Long idOrder,
                                   @PathVariable String orderStatus){
        Order order = orderService.findById(idOrder);
        orderService.changeOrder(order,orderStatus);
        orderService.update(order);
        return order;
    }
}
