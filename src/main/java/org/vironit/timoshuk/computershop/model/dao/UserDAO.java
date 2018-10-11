package org.vironit.timoshuk.computershop.model.dao;

import java.util.List;

public interface UserDAO <Key , User > {

    List <User> findAll() throws DAOException;
    User findUserById (Key id) throws DAOException;
    boolean deleteUser (User user) throws DAOException;
    boolean deleteUserById (Key id) throws DAOException;
    boolean createUser (User user) throws DAOException;
    boolean update (User user, Key id) throws DAOException;

}
