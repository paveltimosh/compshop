package org.vironit.timoshuk.computershop.hibernateDAO;

import java.util.List;

public abstract class EntityDAOImpl<T> implements EntityDAO <T> {

    private Class <T> clazz;

    public  abstract T findById(Long id);
    public  abstract List<T> findAll();
    public  abstract void create(final T entity);
    public  abstract T update(final T entity);
    public  abstract void delete(final T entity);
    public  abstract void deleteById(Long id);
}
