package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DeleteFromCartCommand implements ActionCommand {

    private static final Logger LOG = LogManager.getLogger(DeleteFromCartCommand.class);
    private static final String PARAM_ID_ITEM= "id";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Long id = Long.valueOf(request.getParameter(PARAM_ID_ITEM));
        HashMap <Item, Integer> cart = (HashMap <Item, Integer> ) request.getSession().getAttribute("cart");
        Iterator iterator = cart.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Item, Integer> pair = (Map.Entry<Item, Integer>) iterator.next();
            if (pair.getKey().getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        request.getSession().setAttribute("cart", cart);
        page = URLManager.getProperty("path.page.user.cart");
        return page;
    }
}
