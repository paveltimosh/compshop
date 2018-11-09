package org.vironit.timoshuk.computershop.command.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.command.common.LoginCommand;
import org.vironit.timoshuk.computershop.command.common.ShowCatalogComputerCommand;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.ComputerDAOImpl;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.sql.SQLException;

public class ShowComputerInfoCommand implements ActionCommand {

    private final static Logger LOG = LogManager.getLogger(LoginCommand.class);

    private static final String PARAM_NAME_ID_COMPUTER= "id";


    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Computer computer = null;
        Long id = Long.valueOf(request.getParameter(PARAM_NAME_ID_COMPUTER));
        computer = getEntityComputer(id);
        if (computer !=null){
            request.setAttribute("computer",computer);
            page = URLManager.getProperty("path.page.catalog.computer.info");
        }else {
            page = new ShowCatalogComputerCommand().execute(request);
        }
        return page;
    }

    private Computer  getEntityComputer( Long id){
        Computer computer = null;
        try {
            computer = new ComputerDAOImpl().findById(id);
        } catch (SQLException e) {
            LOG.error("DAOException in method execute");
        }
        return computer;
    }
}
