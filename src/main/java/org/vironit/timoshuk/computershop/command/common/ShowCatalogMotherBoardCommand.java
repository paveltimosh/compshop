package org.vironit.timoshuk.computershop.command.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.products.Components.MotherBoard;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.MotherboardDAOImpl;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ShowCatalogMotherBoardCommand implements ActionCommand {

    private static final Logger LOG = LogManager.getLogger(ShowCatalogMotherBoardCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            List<MotherBoard> motherBoardList = new MotherboardDAOImpl().findAll();
            if(motherBoardList != null){
                request.setAttribute("motherBoards", motherBoardList);
                page = URLManager.getProperty("path.page.catalog.mother_board");
            }else {
                page = URLManager.getProperty("path.page.main");
            }
        } catch (Exception e) {
            LOG.error("DAO Exception");
        }
        return page;
    }
}
