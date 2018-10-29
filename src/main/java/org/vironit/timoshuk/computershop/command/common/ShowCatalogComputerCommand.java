package org.vironit.timoshuk.computershop.command.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.dao.DAOException;
import org.vironit.timoshuk.computershop.dao.impl.ComputerDAOImpl;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowCatalogComputerCommand implements ActionCommand {
    private static final String PARMA_ID_COMPUTER = "";
    private static final Logger LOG = LogManager.getLogger(ShowCatalogComputerCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            List <Computer> computers = new ComputerDAOImpl().findAll();
            if(computers != null){
                request.setAttribute("computers", computers);
                page = URLManager.getProperty("path.page.catalog.computers");
            }else {
                page = URLManager.getProperty("path.page.main");
            }
        } catch (DAOException e) {
            LOG.error("DAO Exception in method execute() ");
        }
        return page;
    }
}
