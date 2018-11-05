package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.products.Components.Case;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaseDAOImpl extends EntityDAOImpl<Case> {

    private Session session;

    public CaseDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Case findById(Long id) throws SQLException {
        Case caze = null;
        caze = session.load(Case.class, id);
        return caze;
    }

    @Override
    public List<Case> findAll() throws SQLException {
        List<Case> caseList = new ArrayList<>();
        Query query = session.createQuery("FROM Case");
        caseList = query.list();
        return caseList;
    }

    @Override
    public void create(Case entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(Case entity) throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Case entity) throws SQLException {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        Case caze = findById(id);
        delete(caze);
    }
}
