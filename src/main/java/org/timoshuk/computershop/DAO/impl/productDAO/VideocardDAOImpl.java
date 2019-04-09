package org.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.timoshuk.computershop.entity.products.Components.VideoCard;
import org.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class VideocardDAOImpl extends EntityDAOImpl<VideoCard, Long> {

    public VideocardDAOImpl(){
        type = VideoCard.class;
    }

}
