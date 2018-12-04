package org.vironit.timoshuk.computershop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.service.OrderService;

import java.util.List;

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
}
