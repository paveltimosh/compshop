package org.vironit.timoshuk.computershop.model.dao;

import java.util.List;

public interface CaseDAO <Key, Case> {
    List <Case> findAll () throws DAOException;
    Case findCaseById (Key id) throws DAOException;
    boolean deleteCaseById (Key id);
    boolean createCase (Case aCase);
    boolean update (Case aCase, Key id);
}
