package org.vironit.timoshuk.computershop.model.dao;

import java.util.List;

public interface ComputerDAO <Key, Computer>{
    List<Computer> findAll () throws DAOException;
    Computer findComputerById (Key id);
    boolean deleteComputerById (Key id);
    boolean createComputer (Computer computer);
    boolean update (Computer computer, Key id);
}
