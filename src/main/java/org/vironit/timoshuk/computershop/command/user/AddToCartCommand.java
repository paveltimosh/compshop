package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.command.common.*;

import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.*;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;

public class AddToCartCommand implements ActionCommand {

    private static final String PARAM_NAME_ITEM_ID = "id";
    private static final String PARAM_NAME_ITEM_TYPE = "itemType";
    private static final Logger LOG = LogManager.getLogger(AddToCartCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        Long itemId = Long.valueOf(request.getParameter(PARAM_NAME_ITEM_ID));
        String itemType = request.getParameter(PARAM_NAME_ITEM_TYPE);
        User user =(User) request.getSession().getAttribute("user");
        if(user == null){
            request.setAttribute("addToCartError", MessageManager.getProperty("message.addToCartError"));
        }else {
            Item item = defineAndGetItemFromDB(itemId, itemType);
            HashMap<Item, Integer> cart = (HashMap<Item, Integer>) request.getSession().getAttribute("cart");
            if (cart.size() == 0) {
                cart.put(item, 1);
            } else {
                if (cart.containsKey(item)) {
                    cart.replace(item, cart.get(item), cart.get(item) + 1);
                } else {
                    cart.put(item, 1);
                }
            }
            request.getSession().setAttribute("cart", cart);
        }
        return pageGenerator(itemType, request);
    }

    private String pageGenerator(String itemType, HttpServletRequest request) {
        String page = null;
        switch (itemType){
            case "computer" :
                page = new ShowCatalogComputerCommand().execute(request);
                break;
            case "cases":
                page = new ShowCatalogCaseCommand().execute(request);
                break;
            case "cpu":
                page = new ShowCatalogCpuCommand().execute(request);
                break;
            case "ram":
                page = new ShowCatalogRamCommand().execute(request);
                break;
            case "videoCard":
                page = new ShowCatalogVideocardCommand().execute(request);
                break;
            case "mother_board":
                page = new ShowCatalogMotherBoardCommand().execute(request);
                break;
        }
        return page;
    }

    private Item defineAndGetItemFromDB(Long itemId, String itemType) {
        Item item = null;
        try {
            switch (itemType){
                case "computer" :
                    item = new ComputerDAOImpl().findById(itemId);
                    break;
                case "cases":
                    item = new CaseDAOImpl().findById(itemId);
                    break;
                case "cpu":
                    item = new CpuDAOImpl().findById(itemId);
                    break;
                case "ram":
                    item = new RamDAOImpl().findById(itemId);
                    break;
                case "videoCard":
                    item = new VideocardDAOImpl().findById(itemId);
                    break;
                case "mother_board":
                    item = new MotherboardDAOImpl().findById(itemId);
                    break;
                default:
                    item = null;
            }
        } catch (Exception e) {
            LOG.error("DAOException");
        }
        return item;
    }
}
