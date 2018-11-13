package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.vironit.timoshuk.computershop.entity.products.Components.CPU;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;


public class CpuDAOImpl extends EntityDAOImpl <CPU, Long> {

    public CpuDAOImpl(){
        type = CPU.class;
    }

}
