package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.entity.products.Item;

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
            Map.Entry<Computer, Integer> pair = (Map.Entry<Computer, Integer>) iterator.next();
            if (pair.getKey() == id) {
                iterator.remove();
            }
        }
        return page;
    }
}
