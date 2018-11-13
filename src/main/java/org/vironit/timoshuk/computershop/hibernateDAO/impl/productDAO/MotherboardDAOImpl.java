package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.vironit.timoshuk.computershop.entity.products.Components.MotherBoard;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;
import org.vironit.timoshuk.computershop.util.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotherboardDAOImpl extends EntityDAOImpl <MotherBoard, Long> {

    public MotherboardDAOImpl(){
        type = MotherBoard.class;
        System.out.println("имя карты"+type.getCanonicalName());
        System.out.println(type.getName());
        System.out.println(type.toString());
    }

}
