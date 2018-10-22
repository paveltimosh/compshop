package org.vironit.timoshuk.computershop.dao;

import java.util.List;

public interface EntityDAO <K, T> {
    List<T> findAll() throws DAOException;
    T findEntityById (K id) throws DAOException;
    boolean deleteEntity (T entity) throws DAOException;
    boolean deleteEntityById (K id) throws DAOException;
    boolean createEntity(T entity) throws DAOException;
    boolean update (T entity, K id) throws DAOException;
}
