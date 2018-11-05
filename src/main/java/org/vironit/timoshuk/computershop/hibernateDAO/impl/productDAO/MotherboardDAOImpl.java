package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.products.Components.MotherBoard;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotherboardDAOImpl extends EntityDAOImpl <MotherBoard> {

    private Session session;

    public MotherboardDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public MotherBoard findById(Long id) throws SQLException {
        MotherBoard motherBoard = null;
        motherBoard = session.load(MotherBoard.class, id);
        return motherBoard;
    }

    @Override
    public List<MotherBoard> findAll() throws SQLException {
        List<MotherBoard> motherBoards = new ArrayList<>();
        Query query = session.createQuery("FROM MotherBoard");
        motherBoards = query.list();
        return motherBoards;
    }

    @Override
    public void create(MotherBoard entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(MotherBoard entity) throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(MotherBoard entity) throws SQLException {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        MotherBoard motherBoard = findById(id);
        delete(motherBoard);
    }
}
