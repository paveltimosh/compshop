package org.timoshuk.computershop.service;

import org.timoshuk.computershop.DTO.CartPositionDTO;
import org.timoshuk.computershop.DTO.UserDTO;
import org.timoshuk.computershop.entity.order.Order;

import java.util.List;

public interface OrderService {
    Order findById(Long id);
    List<Order> findAll();
    List<Order> findAllByUserId(Long userId);
    List<Order> findAllByOrderStatus(String orderStatus);
    void create(final Order order);
    void update(final Order order);
    void delete(final Order order);
    void deleteById(Long id);
    void changeOrder(Order order, String orderStatus);
    Order createOrderEntity( Long userId, List<CartPositionDTO> cartList, String descr);
    String createDescriptionOfOrder(List<CartPositionDTO> cartList );
    void confirmOrder(UserDTO user, Order order, String paymentType);
}
