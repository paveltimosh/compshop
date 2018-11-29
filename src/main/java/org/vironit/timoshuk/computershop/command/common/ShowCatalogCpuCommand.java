package org.vironit.timoshuk.computershop.command.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.products.Components.CPU;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.CpuDAOImpl;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ShowCatalogCpuCommand implements ActionCommand {

    private static final Logger LOG = LogManager.getLogger(ShowCatalogCpuCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            List<CPU> cpuList = new CpuDAOImpl().findAll();
            if(cpuList != null){
                request.setAttribute("CPUs", cpuList);
                page = URLManager.getProperty("path.page.catalog.cpu");
            }else {
                page = URLManager.getProperty("path.page.main");
            }
        } catch (Exception e) {
            LOG.error("DAO Exception");
        }
        return page;
    }
}
