package org.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.timoshuk.computershop.entity.products.Components.RAM;
import org.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class RamDAOImpl extends EntityDAOImpl <RAM, Long> {

    public RamDAOImpl(){
        type = RAM.class;
    }

}
