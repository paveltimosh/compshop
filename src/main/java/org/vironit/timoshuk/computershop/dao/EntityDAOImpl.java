package org.vironit.timoshuk.computershop.dao;

import java.util.List;

public abstract class EntityDAOImpl<K, T> implements EntityDAO<K, T>   {

    public  abstract List<T> findAll() throws DAOException;
    public  abstract T findEntityById(K id) throws DAOException;
    public  abstract boolean deleteEntity(T entity) throws DAOException;
    public  abstract boolean deleteEntityById(K id) throws DAOException;
    public  abstract boolean createEntity(T entity) throws DAOException;
    public  abstract boolean update(T entity) throws DAOException;
}
