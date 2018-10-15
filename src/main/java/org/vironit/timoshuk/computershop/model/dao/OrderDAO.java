package org.vironit.timoshuk.computershop.model.dao;

import java.util.List;

public interface OrderDAO <Key, Order> {
    List<Order> findAll() throws DAOException;
    Order findOrderById (Key id) throws DAOException;
    boolean deleteOrderById (Key id) throws DAOException;
    boolean createOrder (Order order) throws DAOException;
    boolean update (Order order, Key id) throws DAOException;

}
