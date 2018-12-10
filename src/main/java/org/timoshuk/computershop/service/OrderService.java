package org.timoshuk.computershop.service;

import org.timoshuk.computershop.entity.order.Order;
import org.timoshuk.computershop.entity.products.Item;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    Order findById(Long id);
    List<Order> findAll();
    void create(final Order order);
    void update(final Order order);
    void delete(final Order order);
    void deleteById(Long id);
    List<Order> findAllByUserId(Long userId);
    Order createOrderEntity( Long userId, int totalAmountOfOrder, String descr);
    String createDescriptionOfOrder( HashMap<Item, Integer> cart );
    void changePaymentDescrOfOrder(Order order, String paymentType);
}
