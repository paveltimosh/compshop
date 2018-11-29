package org.vironit.timoshuk.computershop.command.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.products.Components.RAM;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.RamDAOImpl;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ShowCatalogRamCommand implements ActionCommand {
    private static final Logger LOG = LogManager.getLogger(ShowCatalogRamCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            List<RAM> ramList = new RamDAOImpl().findAll();
            if(ramList != null){
                request.setAttribute("RAMs", ramList);
                page = URLManager.getProperty("path.page.catalog.ram");
            }else {
                page = URLManager.getProperty("path.page.main");
            }
        } catch (Exception e) {
            LOG.error("DAO Exception");
        }
        return page;
    }
}
