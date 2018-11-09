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

    public User findByParameter(String nameOfParamFromDB, String paramValue)throws SQLException{
        User user = null;
        String sql = "FROM User where " + nameOfParamFromDB + " =:paramValue";
        Query query = session.createQuery(sql);
        query.setParameter("paramValue", paramValue);
        user = (User) query.uniqueResult();
        return user;
    }

    public boolean checkLogin (String login) throws SQLException{
        boolean result = false;
        User user = findByParameter("login", login);
        if (user != null){
            result = true;
        }
        return result;
    }

    public boolean checkEmail (String email) throws SQLException{
        boolean result = false;
        User user = findByParameter("email", email);
        if (user != null){
            result = true;
        }
        return result;
    }

    public boolean checkBankCard (String bankCard) throws SQLException{
        boolean result = false;
        User user = findByParameter("id_card", bankCard);
        if (user != null){
            result = true;
        }
        return result;
    }
}
