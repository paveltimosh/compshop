package org.vironit.timoshuk.computershop.service;

import org.vironit.timoshuk.computershop.entity.order.Order;

import java.util.List;

public interface OrderService {
    Order findById(Long id);
    List<Order> findAll();
    void create(final Order order);
    void update(final Order order);
    void delete(final Order order);
    void deleteById(Long id);
    List<Order> findAllByUserId(Long userId);
}
