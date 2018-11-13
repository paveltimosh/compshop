package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.vironit.timoshuk.computershop.entity.products.Components.MotherBoard;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;

public class MotherboardDAOImpl extends EntityDAOImpl <MotherBoard, Long> {

    public MotherboardDAOImpl(){
        type = MotherBoard.class;
        System.out.println("имя карты"+type.getCanonicalName());
        System.out.println(type.getName());
        System.out.println(type.toString());
    }

}
