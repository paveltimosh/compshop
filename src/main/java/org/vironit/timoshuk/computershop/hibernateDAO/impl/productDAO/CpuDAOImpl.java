package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.products.Components.CPU;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CpuDAOImpl extends EntityDAOImpl <CPU> {

    private Session session;

    public CpuDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public CPU findById(Long id) throws SQLException {
        CPU cpu = null;
        cpu = session.load(CPU.class, id);
        return cpu;
    }

    @Override
    public List<CPU> findAll() throws SQLException {
        List<CPU> cpuList = new ArrayList<>();
        Query query = session.createQuery("FROM CPU");
        cpuList = query.list();
        return cpuList;
    }

    @Override
    public void create(CPU entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(CPU entity) throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(CPU entity) throws SQLException {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        CPU cpu = findById(id);
        delete(cpu);
    }
}
