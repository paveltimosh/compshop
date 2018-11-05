package org.vironit.timoshuk.computershop.hibernateDAO.impl;

import org.hibernate.Session;
import org.vironit.timoshuk.computershop.entity.products.Components.CPU;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class CpuDAOImpl extends EntityDAOImpl <CPU> {

    private Session session;

    public CpuDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public CPU findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<CPU> findAll() throws SQLException {
        return null;
    }

    @Override
    public void create(CPU entity) throws SQLException {

    }

    @Override
    public void update(CPU entity) throws SQLException {

    }

    @Override
    public void delete(CPU entity) throws SQLException {

    }

    @Override
    public void deleteById(Long id) throws SQLException {

    }
}
