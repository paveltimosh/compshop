package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.dao.DAOException;
import org.vironit.timoshuk.computershop.dao.impl.ComputerDAOImpl;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class AddToCartCommand implements ActionCommand {

    private static final String PARAM_NAME_ITEM_ID = "id";
    private static final Logger LOG = LogManager.getLogger(AddToCartCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Long itemId = Long.valueOf(request.getParameter(PARAM_NAME_ITEM_ID));

        try {
            Computer computer = new ComputerDAOImpl().findEntityById(itemId);
            HashMap<Item, Integer> cart = (HashMap<Item, Integer>) request.getSession().getAttribute("cart");
            if(cart.size() == 0){
                cart.put(computer, 1);
            }else {
                if(cart.containsKey(computer)){
                    cart.replace(computer, cart.get(computer),cart.get(computer)+1);
                }else {
                    cart.put(computer, 1);
                }
            }
            request.getSession().setAttribute("cart", cart);
            page = URLManager.getProperty("path.page.catalog.computers");
        } catch (DAOException e) {
            LOG.error("DAOException");
        }catch (ClassCastException e){
            LOG.error("Error ");
        }
        return page;
    }
}
