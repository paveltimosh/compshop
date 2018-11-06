package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowOrderUserCommand implements ActionCommand {

    private static final Logger LOG = LogManager.getLogger(ShowOrderUserCommand.class);


    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        User user = (User)request.getSession().getAttribute("user");
        Long userId = user.getId();
        List<Order> orderList = new ArrayList<>();
        try {
            orderList = new OrderDAOImpl().findAllByUserId(userId);
        } catch (SQLException e) {
            LOG.error("SQLException in method execute");
        }
        request.setAttribute("orders", orderList );
        page = URLManager.getProperty("path.page.user.orders");
        return page;
    }
}
