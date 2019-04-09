package org.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.timoshuk.computershop.entity.products.Components.MotherBoard;
import org.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class MotherboardDAOImpl extends EntityDAOImpl <MotherBoard, Long> {

    public MotherboardDAOImpl(){
        type = MotherBoard.class;
    }

}
