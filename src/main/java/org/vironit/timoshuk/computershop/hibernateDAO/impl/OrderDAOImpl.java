package org.vironit.timoshuk.computershop.hibernateDAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl extends EntityDAOImpl <Order, Long> {

    public OrderDAOImpl(){
        type = Order.class;
    }

    public List<Order> findAllByUserId(Long userId) throws SQLException {
        List<Order> orderList = new ArrayList<>();
        Query query = getCurrentSession().createQuery("FROM Order WHERE id_of_customer =:paramUserId");
        query.setParameter("paramUserId", userId);
        orderList = query.list();
        return orderList;
    }
}
