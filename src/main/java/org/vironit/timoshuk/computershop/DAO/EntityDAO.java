package org.vironit.timoshuk.computershop.DAO;

import java.sql.SQLException;
import java.util.List;

public interface EntityDAO <T, K>{


    T findById(K id) throws SQLException;
    List<T> findAll() throws SQLException;
    void create(final T entity) throws SQLException;
    void update(final T entity) throws SQLException;
    void delete(final T entity) throws SQLException;
    void deleteById(K id) throws SQLException;

}
