package org.vironit.timoshuk.computershop.hibernateDAO.impl;


import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;

import java.util.List;


public class UserDAOImpl extends EntityDAOImpl <User> {


    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
