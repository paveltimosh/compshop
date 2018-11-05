package org.vironit.timoshuk.computershop.hibernateDAO;

import java.sql.SQLException;
import java.util.List;

public abstract class EntityDAOImpl<T> implements EntityDAO <T> {

    public  abstract T findById(Long id) throws SQLException;
    public  abstract List<T> findAll()throws SQLException;
    public  abstract void create(final T entity)throws SQLException;
    public  abstract void update(final T entity)throws SQLException;
    public  abstract void delete(final T entity)throws SQLException;
    public  abstract void deleteById(Long id)throws SQLException;
}
