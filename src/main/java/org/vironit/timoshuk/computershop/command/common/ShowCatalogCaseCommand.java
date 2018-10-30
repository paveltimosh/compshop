package org.vironit.timoshuk.computershop.command.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.dao.DAOException;
import org.vironit.timoshuk.computershop.dao.impl.CaseDAOIml;
import org.vironit.timoshuk.computershop.entity.products.Components.Case;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowCatalogCaseCommand implements ActionCommand {

    private static final Logger LOG = LogManager.getLogger(ShowCatalogCaseCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            List<Case> cases = new CaseDAOIml().findAll();
            if(cases != null){
                request.setAttribute("cases", cases);
                page = URLManager.getProperty("path.page.catalog.cases");
            }else {
                page = URLManager.getProperty("path.page.main");
            }
        } catch (DAOException e) {
            LOG.error("DAO Exception");
        }
        return page;
    }
}
