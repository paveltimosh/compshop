package org.vironit.timoshuk.computershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.vironit.timoshuk.computershop.DTO.UserDTO;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.entity.order.TypePayment;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.util.MessageManager;
import org.vironit.timoshuk.computershop.service.OrderService;
import org.vironit.timoshuk.computershop.service.UserService;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/make_order", method = RequestMethod.POST)
    public ModelAndView makeOrder(@RequestParam String summa,
                                  @SessionAttribute UserDTO user,
                                  HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("user/cart");
        HashMap<Item, Integer> cart = (HashMap<Item, Integer>) session.getAttribute("cart");
        if(!cart.isEmpty()){
            int totalAmountOfOrder = Integer.valueOf(summa.trim());
            String orderDescription = orderService.createDescriptionOfOrder( cart);
            Order order = orderService.createOrderEntity(user.getId(), totalAmountOfOrder, orderDescription.trim());
            orderService.create(order);
            cart = new HashMap<>();
            modelAndView.addObject("orderSuccessful", MessageManager.getProperty("message.orderSuccessful"));
            session.setAttribute("cart", cart);
        }else {
            modelAndView.addObject("orderError", MessageManager.getProperty("message.orderError"));
        }
        return modelAndView;
    }

    @GetMapping("user/orders")
    public ModelAndView showOrdersOfUser(@SessionAttribute UserDTO user){
        ModelAndView modelAndView = new ModelAndView("user/orders");
        List<Order> orderList = orderService.findAllByUserId(user.getId());
        modelAndView.addObject("orders", orderList );
        return modelAndView;
    }

    @PostMapping("user/orders/delete")
    public ModelAndView deleteOrderByUser(@RequestParam Long orderId,
                                          @SessionAttribute UserDTO user){
        ModelAndView modelAndView = new ModelAndView("user/orders");
        Order order = orderService.findById(orderId);
        if (order != null && order.getOrderStatus().equals(OrderStatus.IS_CONFIRMED)){
            orderService.delete(order);
            modelAndView.addObject("deleteOrderSuccess", MessageManager.getProperty("message.order.deleteSuccess"));
        }else {
            modelAndView.addObject("deletePayedOrderError", MessageManager.getProperty("message.orderPayed.deleteError"));
        }
        List<Order> orderList = orderService.findAllByUserId(user.getId());
        modelAndView.addObject("orders", orderList );
        return modelAndView;
    }

    @PostMapping("user/orders/confirm")
    public ModelAndView confirmOrder(@RequestParam Long orderId,
                                     @RequestParam String paymentType,
                                     @SessionAttribute UserDTO user,
                                     HttpSession session){
        ModelAndView modelAndView = new ModelAndView("redirect:/user/orders");
        int ownMoney = 0;
        if(user.getOwnMoney()!= null) {
            ownMoney = user.getOwnMoney();
        }
        Order order = orderService.findById(orderId);
        if(order.getOrderStatus().equals(OrderStatus.IS_PAYED)){
            modelAndView.addObject("orderAlsoConfirmed", MessageManager.getProperty("message.orderAlsoConfirm"));
            return modelAndView;
        }
        if(paymentType.equals(TypePayment.BANK_CARD.toString())){
            if (ownMoney >= order.getTotalAmountOrder()){
                orderService.changePaymentDescrOfOrder(order, paymentType);
                user.setOwnMoney(ownMoney - order.getTotalAmountOrder());
                userService.update(user);
                session.setAttribute("user", user);
                modelAndView.addObject("orderConfirmSuc", MessageManager.getProperty("message.orderConfirmSuccessful"));
            }else {
                modelAndView.addObject("orderConfirmError", MessageManager.getProperty("message.orderConfirmError"));
            }
        }else {
            orderService.changePaymentDescrOfOrder(order, paymentType);
            modelAndView.addObject("orderConfirmSuc", MessageManager.getProperty("message.orderConfirmSuccessful"));
        }
        orderService.update(order);
        List<Order> orderList = orderService.findAllByUserId(user.getId());
        modelAndView.addObject("orders", orderList );
        return modelAndView;
    }
}
