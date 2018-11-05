package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.command.common.ShowCatalogCaseCommand;
import org.vironit.timoshuk.computershop.command.common.ShowCatalogComputerCommand;
import org.vironit.timoshuk.computershop.dao.DAOException;
import org.vironit.timoshuk.computershop.dao.impl.CaseDAOIml;
import org.vironit.timoshuk.computershop.dao.impl.ComputerDAOImpl;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import javax.servlet.http.HttpServletRequest;
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
            Item item = getItemFromDB(itemId, itemType);
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
        }
        return page;
    }

    private Item getItemFromDB(Long itemId, String itemType) {
        Item item = null;
        try {
            switch (itemType){
                case "computer" :
                    item = new ComputerDAOImpl().findEntityById(itemId);
                    break;
                case "cases":
                    item = new CaseDAOIml().findEntityById(itemId);
                    break;
            }
        } catch (DAOException e) {
            LOG.error("DAOException");
        }
        return item;
    }
}
