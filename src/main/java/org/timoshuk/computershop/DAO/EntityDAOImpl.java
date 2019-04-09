package org.timoshuk.computershop.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public abstract class EntityDAOImpl<T,K extends Long> implements EntityDAO <T, K> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<T> type;

    @Override
    public T findById(K id){
        T entity = null;
        entity = getCurrentSession().get(type, id);
        return entity;
    }

    @Override
    public List<T> findAll(){
        List<T> entities = new ArrayList<>();
        Query query = getCurrentSession().createQuery("FROM " + type.getName());
        entities = query.list();
        return entities;
    }

    @Override
    public  void create(final T entity){
        getCurrentSession().save(entity);
    }

    @Override
    public void update(final T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(final T entity){
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(K id){
        T entity = findById(id);
        delete(entity);
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
