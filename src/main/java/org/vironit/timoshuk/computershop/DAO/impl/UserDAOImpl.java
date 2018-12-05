package org.vironit.timoshuk.computershop.DAO.impl;

import org.hibernate.NonUniqueResultException;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class UserDAOImpl extends EntityDAOImpl <User, Long> {

    public UserDAOImpl(){
        type = User.class;
    }

    public User findByParameter(String nameOfParam, String paramValue)throws NonUniqueResultException {
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

    public boolean checkLogin (String login)throws NonUniqueResultException {
        boolean result = false;
        User user = findByParameter("login", login);
        if (user != null){
            result = true;
        }
        return result;
    }


    public boolean checkEmail (String email)throws NonUniqueResultException  {
        boolean result = false;
        User user = findByParameter("email", email);
        if (user != null){
            result = true;
        }
        return result;
    }

    public boolean checkBankCard (String bankCard)throws NonUniqueResultException {
        boolean result = false;
        User user = findByParameter("idCard", bankCard);
        if (user != null){
            result = true;
        }
        return result;
    }
}
