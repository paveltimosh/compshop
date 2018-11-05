package org.vironit.timoshuk.computershop.hibernateDAO.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerDAOImpl extends EntityDAOImpl <Computer> {
    private Session session;

    public ComputerDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Computer findById(Long id) throws SQLException {
        Computer computer = null;
        computer = session.load(Computer.class, id);

        return computer;
    }

    @Override
    public List<Computer> findAll() throws SQLException {
        List<Computer> computers = new ArrayList<>();
        Query query = session.createQuery("FROM Computer");
        computers = query.list();
        return computers;
    }

    @Override
    public void create(Computer entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(Computer entity) throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Computer entity) throws SQLException {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        Computer computer = null;
        computer = session.load(Computer.class, id);
        delete(computer);
    }
}
