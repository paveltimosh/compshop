package org.vironit.timoshuk.computershop.hibernateDAO.impl;

import org.hibernate.Session;

import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl extends EntityDAOImpl <User> {
    private Session session;


    public UserDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public User findById(Long id) throws SQLException {
        User user = null;
        user = session.load(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        Query query = session.createQuery("FROM User");
        users = query.list();
        return users;
    }

    @Override
    public void create(User entity)throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(User entity)throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(User entity) throws SQLException{
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) throws SQLException{
        User user = null;
        user = session.load(User.class, id);
        delete(user);
    }

    public User findByLogin (String login)throws SQLException{
        User user = null;
        String sql = "FROM User where login =:paramLogin";
        Query query = session.createQuery(sql);
        query.setParameter("paramLogin", login);
        user = (User) query.uniqueResult();
        return user;
    }
}
