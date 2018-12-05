package org.vironit.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.vironit.timoshuk.computershop.entity.products.Components.CPU;
import org.vironit.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class CpuDAOImpl extends EntityDAOImpl <CPU, Long> {

    public CpuDAOImpl(){
        type = CPU.class;
    }

}
