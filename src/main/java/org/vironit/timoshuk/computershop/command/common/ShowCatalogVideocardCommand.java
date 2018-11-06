package org.vironit.timoshuk.computershop.command.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.products.Components.VideoCard;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.VideocardDAOImpl;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class ShowCatalogVideocardCommand implements ActionCommand {

    private static final Logger LOG = LogManager.getLogger(ShowCatalogVideocardCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        try {
            List<VideoCard> videoCardList = new VideocardDAOImpl().findAll();
            if(videoCardList != null){
                request.setAttribute("videoCards", videoCardList);
                page = URLManager.getProperty("path.page.catalog.videocard");
            }else {
                page = URLManager.getProperty("path.page.main");
            }
        } catch (SQLException e) {
            LOG.error("DAO Exception");
        }
        return page;
    }
}
