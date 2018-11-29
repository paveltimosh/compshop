package org.vironit.timoshuk.computershop.hibernateDAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;

@Repository
public class UserDAOImpl extends EntityDAOImpl <User, Long> {

    public UserDAOImpl(){
        type = User.class;
    }

    public User findByParameter(String nameOfParam, String paramValue){
        User user = null;
        String sql = "FROM User where " + nameOfParam + " =:paramValue";
        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("paramValue", paramValue);
        user = (User) query.uniqueResult();
        return user;
    }

    public User findByLogin (String login){
        User user = null;
        String sql = "FROM User where login " + " =:paramValue";
        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("paramValue", login);
        user = (User) query.uniqueResult();
        return user;
    }

    public boolean checkLogin (String login) {
        boolean result = false;
        Session session = getCurrentSession();
        getCurrentSession().beginTransaction();
        User user = findByParameter("login", login);
        if (user != null){
            result = true;
        }
        session.getTransaction().commit();
        return result;
    }


    public boolean checkEmail (String email) {
        boolean result = false;
        Session session = getCurrentSession();
        getCurrentSession().beginTransaction();
        User user = findByParameter("email", email);
        if (user != null){
            result = true;
        }
        System.out.println("чекинг мыла");
        session.getTransaction().commit();
        return result;
    }

    public boolean checkBankCard (String bankCard){
        boolean result = false;
        System.out.println(bankCard);
        User user = findByParameter("idCard", bankCard);
        if (user != null){
            result = true;
        }
        System.out.println("банк карты чекинг");

        return result;
    }
}
