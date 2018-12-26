package org.timoshuk.computershop.service;

import org.timoshuk.computershop.DTO.CartPositionDTO;
import org.timoshuk.computershop.entity.order.Order;

import java.util.List;

public interface OrderService {
    Order findById(Long id);
    List<Order> findAll();
    void create(final Order order);
    void update(final Order order);
    void delete(final Order order);
    void deleteById(Long id);
    List<Order> findAllByUserId(Long userId);
    Order createOrderEntity( Long userId, List<CartPositionDTO> cartList, String descr);
    String createDescriptionOfOrder(List<CartPositionDTO> cartList );
    void changePaymentDescrOfOrder(Order order, String paymentType);
}
