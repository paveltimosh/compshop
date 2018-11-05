package org.vironit.timoshuk.computershop.hibernateDAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl extends EntityDAOImpl <Order> {

    private Session session;

    public OrderDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Order findById(Long id) throws SQLException {
        Order order = null;
        order = session.load(Order.class, id);
        return order;
    }

    @Override
    public List<Order> findAll() throws SQLException {
        List<Order> orderList = new ArrayList<>();
        Query query = session.createQuery("FROM Order");
        orderList = query.list();
        return orderList;
    }

    @Override
    public void create(Order entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(Order entity) throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Order entity) throws SQLException {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        Order order = findById(id);
        delete(order);
    }
}
