package org.vironit.timoshuk.computershop.model.dao;

import java.util.List;

public interface UserDAO <Key , User > {

    List <User> findAll() throws DAOException, DAOException;
    User findUserById (Key id) throws DAOException, DAOException;
    boolean deleteUser (User customer) throws DAOException, DAOException;
    boolean deleteUserById (Key id) throws DAOException, DAOException;
    boolean createUser (User customer) throws DAOException, DAOException;
    boolean update (User customer, Key id) throws DAOException, DAOException;

}
