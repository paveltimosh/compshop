package org.vironit.timoshuk.computershop.DAO.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.DAO.EntityDAOImpl;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAOImpl extends EntityDAOImpl <Order, Long> {

    public OrderDAOImpl(){
        type = Order.class;
    }

    public List<Order> findAllByUserId(Long userId) {
        List<Order> orderList = new ArrayList<>();
        Query query = getCurrentSession().createQuery("FROM Order WHERE id_of_customer =:paramUserId");
        query.setParameter("paramUserId", userId);
        orderList = query.list();
        return orderList;
    }
}
