package org.timoshuk.computershop.service.impl.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.timoshuk.computershop.entity.products.Components.VideoCard;
import org.timoshuk.computershop.DAO.impl.productDAO.VideocardDAOImpl;
import org.timoshuk.computershop.exception.EntityNotFoundException;
import org.timoshuk.computershop.service.VideocardService;

import java.util.List;

@Service
public class VideocardImpl implements VideocardService {

    @Autowired
    private VideocardDAOImpl videocardDAO;

    @Transactional
    @Override
    public VideoCard findById(Long id) {
        VideoCard videoCard = videocardDAO.findById(id);
        if(videoCard == null){
            throw new EntityNotFoundException("Video card not found");
        }
        return videoCard;
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
        VideoCard videoCard = videocardDAO.findById(id);
        if(videoCard == null){
            throw new EntityNotFoundException("Video card not found");
        }
        videocardDAO.deleteById(id);
    }
}
