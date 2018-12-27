package org.timoshuk.computershop.service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timoshuk.computershop.DAO.impl.OrderDAOImpl;
import org.timoshuk.computershop.DAO.impl.UserDAOImpl;
import org.timoshuk.computershop.DTO.CartPositionDTO;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.entity.order.Order;
import org.timoshuk.computershop.entity.order.OrderStatus;
import org.timoshuk.computershop.entity.order.PaymentDescription;
import org.timoshuk.computershop.entity.order.TypePayment;
import org.timoshuk.computershop.entity.products.Item;
import org.timoshuk.computershop.exception.EntityNotFoundException;
import org.timoshuk.computershop.exception.NotEnoughMoneyException;
import org.timoshuk.computershop.exception.OrderIsPayedException;
import org.timoshuk.computershop.service.OrderService;
import org.timoshuk.computershop.service.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAOImpl orderDAO;

    @Autowired
    private UserDAOImpl userDAO;

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public Order findById(Long id) {
        Order order = orderDAO.findById(id);
        if (order == null){
            throw new EntityNotFoundException("Order not found");
        }
        return order;
    }

    @Transactional
    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Transactional
    @Override
    public void create(Order order) {
        orderDAO.create(order);
    }

    @Transactional
    @Override
    public void update(Order order) {
        orderDAO.update(order);
    }

    @Transactional
    @Override
    public void delete(Order order) {
        orderDAO.delete(order);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Order order = orderDAO.findById(id);
        if (order == null){
            throw new EntityNotFoundException("Order not found");
        }
        orderDAO.deleteById(id);
    }

    @Override
    public void changeOrder(Order order, String orderStatus) {
        if (checkAcceptableOfOrderStatus(orderStatus)){
            order.setOrderStatus(OrderStatus.valueOf(orderStatus));
        }else {
            throw new IllegalArgumentException("As order status you can use only: IS_PAYED, IS_CONFIRMED, IS_CANCELLED, IS_COMPLETED, IS_READY_FOR_DELIVERY");
        }
    }

    @Transactional
    @Override
    public List<Order> findAllByUserId(Long userId) {
        if (userDAO.findById(userId) == null){
            throw new EntityNotFoundException("User not found");
        }
        return orderDAO.findAllByUserId(userId);
    }

    @Transactional
    @Override
    public List<Order> findAllByOrderStatus(String orderStatus) {
        if(!checkAcceptableOfOrderStatus(orderStatus)) {
            throw new IllegalArgumentException("As order status you can use only: IS_PAYED, IS_CONFIRMED, IS_CANCELLED, IS_COMPLETED, IS_READY_FOR_DELIVERY");
        }
        return orderDAO.findAllByOrderStatus(orderStatus);
    }

    @Transactional
    @Override
    public void confirmOrder(UserDTO user, Order order, String paymentType){
        int ownMoney = user.getOwnMoney();
        if(order.getOrderStatus().equals(OrderStatus.IS_PAYED)){
            throw new OrderIsPayedException("Order already paid");
        }
        if(paymentType.equals(TypePayment.BANK_CARD.toString())){
            if (ownMoney >= order.getTotalAmountOrder()){
                changePaymentDescrOfOrder(order, paymentType);
                user.setOwnMoney(ownMoney - order.getTotalAmountOrder());
                userService.update(user);
            }else {
                throw new NotEnoughMoneyException("User don't have enough money!");
            }
        }else {
            changePaymentDescrOfOrder(order, paymentType);
        }
    }

    @Override
    public Order createOrderEntity( Long userId, List<CartPositionDTO> cartList, String descr){
        Order order = null;
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        Integer totalAmount = 0;
        for (CartPositionDTO cartPositionDTO : cartList) {
            totalAmount = totalAmount + cartPositionDTO.getPrice()*cartPositionDTO.getCount();
        }
        order = Order.builder().idOfCustomer(userId).dateOfOrder(dateNow).timeOfOrder(timeNow)
                .totalAmountOrder(totalAmount).orderStatus(OrderStatus.IS_CONFIRMED).orderDescription(descr).paymentDescription(
                        PaymentDescription.builder()
                                .build()
                ).build();
        return order;
    }

    @Override
    public String createDescriptionOfOrder( List<CartPositionDTO> cartList ){
        String orderDescription = "";
        for (CartPositionDTO cart : cartList){
            orderDescription = orderDescription.concat(cart.getModelOfItem()).concat(" ");
        }
        return orderDescription;
    }

    private void changePaymentDescrOfOrder(Order order, String paymentType){
        if(paymentType.equals(TypePayment.BANK_CARD.toString()) || paymentType.equals(TypePayment.CASH.toString())
                || paymentType.equals(TypePayment.CREDIT.toString()) ) {
            LocalDate dateNow = LocalDate.now();
            LocalTime timeNow = LocalTime.now();
            order.setOrderStatus(OrderStatus.IS_PAYED);
            order.setPaymentDescription(PaymentDescription.builder()
                    .typePayment(TypePayment.valueOf(paymentType))
                    .dateOfPayment(dateNow)
                    .timeOfPayment(timeNow)
                    .build());
        }else {
            throw new IllegalArgumentException("As payment type you can use only: BANK_CARD, CASH, CREDIT");
        }
    }

    private boolean checkAcceptableOfOrderStatus(String orderStatus){
        boolean acceptable = false;
        if(orderStatus.equals(OrderStatus.IS_PAYED.toString())
                || orderStatus.equals(OrderStatus.IS_CONFIRMED.toString())
                || orderStatus.equals(OrderStatus.IS_CANCELLED.toString())
                || orderStatus.equals(OrderStatus.IS_COMPLETED.toString())
                || orderStatus.equals(OrderStatus.IS_READY_FOR_DELIVERY.toString())) {
            acceptable = true;
        }
        return acceptable;
    }

}
