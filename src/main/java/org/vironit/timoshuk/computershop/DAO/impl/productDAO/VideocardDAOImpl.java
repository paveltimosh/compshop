package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.vironit.timoshuk.computershop.entity.products.Components.VideoCard;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;

@Repository
public class VideocardDAOImpl extends EntityDAOImpl<VideoCard, Long> {

    public VideocardDAOImpl(){
        type = VideoCard.class;
    }

}
