package org.vironit.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class ComputerDAOImpl extends EntityDAOImpl <Computer, Long> {

    public ComputerDAOImpl(){
        type = Computer.class;
    }

}
