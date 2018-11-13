package org.vironit.timoshuk.computershop.hibernateDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class EntityDAOImpl<T,K extends Long> implements EntityDAO <T, K> {

    protected Class<T> type;

    @Override
    public T findById(K id) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        T entity = null;
        entity = session.get(type, id);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> findAll()throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<T> entities = new ArrayList<>();
        Query query = session.createQuery("FROM " + type.getName());
        entities = query.list();
        session.getTransaction().commit();
        return entities;
    }

    @Override
    public  void create(final T entity)throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(final T entity)throws SQLException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }
    @Override
    public void delete(final T entity)throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(K id)throws SQLException{
        T entity = findById(id);
        delete(entity);
    }
}
