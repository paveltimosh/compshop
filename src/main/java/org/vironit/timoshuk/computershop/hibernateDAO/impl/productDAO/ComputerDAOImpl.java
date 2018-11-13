package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;


public class ComputerDAOImpl extends EntityDAOImpl <Computer, Long> {

    public ComputerDAOImpl(){
        type = Computer.class;
    }

}
