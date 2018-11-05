package org.vironit.timoshuk.computershop.hibernateDAO;

import java.sql.SQLException;
import java.util.List;

public interface EntityDAO <T>{

    T findById(Long id) throws SQLException;
    List<T> findAll() throws SQLException;
    void create(final T entity) throws SQLException;
    void update(final T entity) throws SQLException;
    void delete(final T entity) throws SQLException;
    void deleteById(Long id) throws SQLException;

}
