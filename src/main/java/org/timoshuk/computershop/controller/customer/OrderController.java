package org.timoshuk.computershop.controller.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.timoshuk.computershop.DTO.CartPositionDTO;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.entity.order.Order;
import org.timoshuk.computershop.entity.order.OrderStatus;
import org.timoshuk.computershop.entity.order.TypePayment;
import org.timoshuk.computershop.exception.AccessDeniedException;
import org.timoshuk.computershop.exception.NotEnoughMoneyException;
import org.timoshuk.computershop.exception.OrderIsPayedException;
import org.timoshuk.computershop.service.OrderService;
import org.timoshuk.computershop.service.UserService;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("users/orders")
public class OrderController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public Order makeOrder(@RequestBody List<CartPositionDTO> cart,
                           Principal principal) {
        UserDTO user = userService.findByLogin(principal.getName());
        String descrOfOrder = orderService.createDescriptionOfOrder(cart);
        Order order = orderService.createOrderEntity(user.getId(), cart,descrOfOrder);
        orderService.create(order);
        return order;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> showOrdersOfUser(Principal principal){
        LOG.debug("Method showOrdersOfUser began work");
        String userLogin = principal.getName();
        UserDTO user = userService.findByLogin(userLogin);
        List<Order> orderList = orderService.findAllByUserId(user.getId());
        return orderList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order showOrderById(@PathVariable("id") Long id,
                                     Principal principal){
        LOG.debug("Method showOrderById began work");
        String userLogin = principal.getName();
        UserDTO user = userService.findByLogin(userLogin);
        Order order = orderService.findById(id);
        if(!order.getIdOfCustomer().equals(user.getId())){
            throw new AccessDeniedException("You can't to see this order, because you are not the owner!");
        }
        return order;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOrderByUser(Principal principal,
                                  @PathVariable("id") Long orderId){
        Order order = orderService.findById(orderId);
        UserDTO userDTO = userService.findById(order.getIdOfCustomer());
        if (userDTO.getLogin().equals(principal.getName())) {
            orderService.delete(order);
        }else {
            throw new AccessDeniedException("You are not the owner of this order, so you can't delete it!");
        }
    }

    @RequestMapping(value = "/{id}/confirmation/{paymentType}", method = RequestMethod.PUT)
    public Order confirmOrder(@PathVariable("id") Long idOrder,
                              @PathVariable String paymentType,
                              Principal principal){
        String userLogin = principal.getName();
        UserDTO user = userService.findByLogin(userLogin);
        int ownMoney = user.getOwnMoney();
        Order order = orderService.findById(idOrder);
        if(order.getOrderStatus().equals(OrderStatus.IS_PAYED)){
            throw new OrderIsPayedException("Order already paid");
        }
        if(paymentType.equals(TypePayment.BANK_CARD.toString())){
            if (ownMoney >= order.getTotalAmountOrder()){
                orderService.changePaymentDescrOfOrder(order, paymentType);
                user.setOwnMoney(ownMoney - order.getTotalAmountOrder());
                userService.update(user);
            }else {
                throw new NotEnoughMoneyException("User don't have enough money!");
            }
        }else {
            orderService.changePaymentDescrOfOrder(order, paymentType);
        }
        orderService.update(order);
        return order;
    }
}
