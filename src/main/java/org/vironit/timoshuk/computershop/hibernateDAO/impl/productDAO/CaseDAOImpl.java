package org.vironit.timoshuk.computershop.hibernateDAO.impl;

import org.hibernate.Session;
import org.vironit.timoshuk.computershop.entity.products.Components.Case;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class CaseDAOImpl extends EntityDAOImpl<Case> {

    private Session session;

    public CaseDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Case findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Case> findAll() throws SQLException {
        return null;
    }

    @Override
    public void create(Case entity) throws SQLException {

    }

    @Override
    public void update(Case entity) throws SQLException {

    }

    @Override
    public void delete(Case entity) throws SQLException {

    }

    @Override
    public void deleteById(Long id) throws SQLException {

    }
}
