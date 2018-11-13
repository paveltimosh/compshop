package org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO;

import org.vironit.timoshuk.computershop.entity.products.Components.Case;
import org.vironit.timoshuk.computershop.hibernateDAO.EntityDAOImpl;

public class CaseDAOImpl extends EntityDAOImpl<Case, Long> {

    public CaseDAOImpl(){
        type = Case.class;
    }

}
