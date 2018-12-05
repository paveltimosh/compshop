package org.vironit.timoshuk.computershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.entity.order.PaymentDescription;
import org.vironit.timoshuk.computershop.entity.order.TypePayment;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.DAO.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.service.OrderService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAOImpl orderDAO;

    @Transactional
    @Override
    public Order findById(Long id) {
        return orderDAO.findById(id);
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
        orderDAO.deleteById(id);
    }

    @Transactional
    @Override
    public List<Order> findAllByUserId(Long userId) {
        return orderDAO.findAllByUserId(userId);
    }

    @Override
    public Order createOrderEntity( Long userId, int totalAmountOfOrder, String descr){
        Order order = null;
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        order = Order.builder().idOfCustomer(userId).dateOfOrder(dateNow).timeOfOrder(timeNow)
                .totalAmountOrder(totalAmountOfOrder).orderStatus(OrderStatus.IS_CONFIRMED).orderDescription(descr).paymentDescription(
                        PaymentDescription.builder()
                                .build()
                ).build();
        return order;
    }

    @Override
    public String createDescriptionOfOrder( HashMap<Item, Integer> cart ){
        String orderDescription = "";
        for (Map.Entry <Item, Integer> entry : cart.entrySet()){
            orderDescription = orderDescription.concat(entry.getKey().getModel()).concat(" ");
        }
        return orderDescription;
    }

    @Override
    public void changePaymentDescrOfOrder(Order order, String paymentType){
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        order.setOrderStatus(OrderStatus.IS_PAYED);
        order.setPaymentDescription(PaymentDescription.builder()
                .typePayment(TypePayment.valueOf(paymentType))
                .dateOfPayment(dateNow)
                .timeOfPayment(timeNow)
                .build());
    }
}
