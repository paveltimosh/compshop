package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.vironit.timoshuk.computershop.entity.products.Components.RAM;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;

public class RamDAOImpl extends EntityDAOImpl <RAM, Long> {

    public RamDAOImpl(){
        type = RAM.class;
    }

}
