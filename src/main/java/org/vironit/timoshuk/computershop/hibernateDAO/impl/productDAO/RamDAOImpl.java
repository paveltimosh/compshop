package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.products.Components.RAM;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RamDAOImpl extends EntityDAOImpl <RAM> {

    private Session session;

    public RamDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public RAM findById(Long id) throws SQLException {
        RAM ram = null;
        ram = session.load(RAM.class, id);
        return ram;
    }

    @Override
    public List<RAM> findAll() throws SQLException {
        List<RAM> ramList = new ArrayList<>();
        Query query = session.createQuery("FROM RAM");
        ramList = query.list();
        return ramList;
    }

    @Override
    public void create(RAM entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(RAM entity) throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(RAM entity) throws SQLException {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        RAM ram = findById(id);
        delete(ram);
    }
}
