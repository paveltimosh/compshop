package org.vironit.timoshuk.computershop.model.dao;

import org.vironit.timoshuk.computershop.model.entity.Entity;

import java.util.List;

public interface UserDAO <Key , T extends Entity > {

    List <T> findAll();
    T findUserById (Key id);
    boolean deleteUser (T customer);
    boolean deleteUserById (Key id);
    boolean createUser (T customer);
    boolean update (T customer);

}
