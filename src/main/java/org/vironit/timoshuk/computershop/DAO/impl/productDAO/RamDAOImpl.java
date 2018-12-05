package org.vironit.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.vironit.timoshuk.computershop.entity.products.Components.RAM;
import org.vironit.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class RamDAOImpl extends EntityDAOImpl <RAM, Long> {

    public RamDAOImpl(){
        type = RAM.class;
    }

}
