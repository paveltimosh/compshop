package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LazyInitializationException;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.resource.MessageManager;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class DeleteOrderByUserCommand implements ActionCommand {

    private static final String PARAM_NAME_ID_ORDER = "orderId";
    private static final Logger LOG = LogManager.getLogger(DeleteFromCartCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        Order order = null;
        Long orderId = Long.valueOf(request.getParameter(PARAM_NAME_ID_ORDER));
        try {
            OrderDAOImpl orderDAO = new OrderDAOImpl();
            order = orderDAO.findById(orderId);
            if (order != null && order.getOrderStatus().equals(OrderStatus.IS_CONFIRMED)){
                orderDAO.delete(order);
                request.setAttribute("deleteOrderSuccess", MessageManager.getProperty("message.order.deleteSuccess"));
            }else {
                request.setAttribute("deletePayedOrderError", MessageManager.getProperty("message.orderPayed.deleteError"));
            }
        }catch (PersistenceException  e){
            request.setAttribute("deleteOrderError", MessageManager.getProperty("message.order.deleteError"));
            page = new ShowOrderUserCommand().execute(request);
        }
        page = new ShowOrderUserCommand().execute(request);
        return page;
    }
}
