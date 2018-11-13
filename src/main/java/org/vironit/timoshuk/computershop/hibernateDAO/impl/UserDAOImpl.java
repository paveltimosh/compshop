package org.vironit.timoshuk.computershop.hibernateDAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;
import java.sql.SQLException;

public class UserDAOImpl extends EntityDAOImpl <User, Long> {

    public UserDAOImpl(){
        type = User.class;
    }

    public User findByParameter(String nameOfParamFromDB, String paramValue)throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        User user = null;
        String sql = "FROM User where " + nameOfParamFromDB + " =:paramValue";
        Query query = session.createQuery(sql);
        query.setParameter("paramValue", paramValue);
        user = (User) query.uniqueResult();
        session.getTransaction().commit();
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
