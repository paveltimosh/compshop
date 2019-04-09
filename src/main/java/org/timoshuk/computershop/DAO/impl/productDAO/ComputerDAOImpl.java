package org.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.timoshuk.computershop.entity.products.Computer;
import org.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class ComputerDAOImpl extends EntityDAOImpl <Computer, Long> {

    public ComputerDAOImpl(){
        type = Computer.class;
    }

}
