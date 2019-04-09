package org.timoshuk.computershop.DAO.impl.productDAO;

import org.springframework.stereotype.Repository;
import org.timoshuk.computershop.DAO.EntityDAOImpl;
import org.timoshuk.computershop.entity.products.Components.Case;

@Repository
public class CaseDAOImpl extends EntityDAOImpl<Case, Long> {

    public CaseDAOImpl(){
        type = Case.class;
    }

}
