package org.vironit.timoshuk.computershop.hibernateDAO;

import java.util.List;

public interface EntityDAO <T>{

    T findById(Long id);
    List<T> findAll();
    void create(final T entity);
    T update(final T entity);
    void delete(final T entity);
    void deleteById(Long id);

}
