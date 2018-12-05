package org.vironit.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vironit.timoshuk.computershop.entity.products.Components.VideoCard;
import org.vironit.timoshuk.computershop.DAO.impl.productDAO.VideocardDAOImpl;
import org.vironit.timoshuk.computershop.service.VideocardService;

import java.util.List;

@Service
public class VideocardImpl implements VideocardService {

    @Autowired
    private VideocardDAOImpl videocardDAO;

    @Transactional
    @Override
    public VideoCard findById(Long id) {
        return videocardDAO.findById(id);
    }

    @Transactional
    @Override
    public List<VideoCard> findAll() {
        return videocardDAO.findAll();
    }

    @Transactional
    @Override
    public void create(VideoCard videoCard) {
        videocardDAO.create(videoCard);
    }

    @Transactional
    @Override
    public void update(VideoCard videoCard) {
        videocardDAO.update(videoCard);
    }

    @Transactional
    @Override
    public void delete(VideoCard videoCard) {
        videocardDAO.delete(videoCard);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        videocardDAO.deleteById(id);
    }
}
