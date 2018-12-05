package org.vironit.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.vironit.timoshuk.computershop.entity.products.Components.Case;
import org.vironit.timoshuk.computershop.DAO.EntityDAOImpl;

@Repository
public class CaseDAOImpl extends EntityDAOImpl<Case, Long> {

    public CaseDAOImpl(){
        type = Case.class;
    }

}
