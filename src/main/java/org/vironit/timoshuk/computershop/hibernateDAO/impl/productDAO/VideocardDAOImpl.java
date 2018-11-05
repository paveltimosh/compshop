package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.products.Components.VideoCard;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideocardDAOImpl extends EntityDAOImpl<VideoCard> {

    private Session session;

    public VideocardDAOImpl(){
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public VideoCard findById(Long id) throws SQLException {
        VideoCard videoCard = null;
        videoCard = session.load(VideoCard.class, id);
        return videoCard;
    }

    @Override
    public List<VideoCard> findAll() throws SQLException {
        List<VideoCard> videoCards = new ArrayList<>();
        Query query = session.createQuery("FROM VideoCard");
        videoCards = query.list();
        return videoCards;
    }

    @Override
    public void create(VideoCard entity) throws SQLException {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(VideoCard entity) throws SQLException {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(VideoCard entity) throws SQLException {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        VideoCard videoCard = findById(id);
        delete(videoCard);
    }
}
