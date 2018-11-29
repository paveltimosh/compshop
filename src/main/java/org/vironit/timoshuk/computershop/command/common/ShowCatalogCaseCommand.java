package org.vironit.timoshuk.computershop.command.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.products.Components.Case;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.CaseDAOImpl;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ShowCatalogCaseCommand implements ActionCommand {

    private static final Logger LOG = LogManager.getLogger(ShowCatalogCaseCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            List<Case> cases = new CaseDAOImpl().findAll();
            if(cases != null){
                request.setAttribute("cases", cases);
                page = URLManager.getProperty("path.page.catalog.cases");
            }else {
                page = URLManager.getProperty("path.page.main");
            }
        } catch (Exception e) {
            LOG.error("DAO Exception");
        }
        return page;
    }
}
