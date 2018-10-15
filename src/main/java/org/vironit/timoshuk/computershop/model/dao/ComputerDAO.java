package org.vironit.timoshuk.computershop.model.dao;

import java.util.List;

public interface ComputerDAO <Key, Computer>{
    List<Computer> findAll () throws DAOException;
    Computer findComputerById (Key id) throws DAOException;
    boolean deleteComputerById (Key id) throws DAOException;
    boolean createComputer (Computer computer) throws DAOException;
    boolean update (Computer computer, Key id) throws DAOException;
}
