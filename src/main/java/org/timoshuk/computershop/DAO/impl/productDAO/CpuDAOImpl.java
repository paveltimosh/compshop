package org.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.timoshuk.computershop.entity.products.Components.CPU;
import org.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class CpuDAOImpl extends EntityDAOImpl <CPU, Long> {

    public CpuDAOImpl(){
        type = CPU.class;
    }

}
