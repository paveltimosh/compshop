package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.entity.order.PaymentDescription;
import org.vironit.timoshuk.computershop.entity.products.Item;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class MakeOrderCommand implements ActionCommand {

    private static final String PARAM_NAME_TOTAL_AMOUNT_OF_ORDER = "summa";

    private static final Logger LOG = LogManager.getLogger(MakeOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        String orderDescription = "";
        User user = (User)request.getSession().getAttribute("user");
        Long userId = user.getId();
        HashMap<Item, Integer> cart = (HashMap<Item, Integer>) request.getSession().getAttribute("cart");
        if(!cart.isEmpty()){
            int totalAmountOfOrder = Integer.valueOf(request.getParameter(PARAM_NAME_TOTAL_AMOUNT_OF_ORDER).trim());
            changeDescriptionOfOrder(orderDescription, cart);
            Order order = createOrderEntity(userId, totalAmountOfOrder, orderDescription.trim());
            addOrderToDataBase(order);
            cart = new HashMap<>();
            request.setAttribute("orderSuccessful", MessageManager.getProperty("message.orderSuccessful"));
            request.getSession().setAttribute("cart", cart);
        }else {
            request.setAttribute("orderError", MessageManager.getProperty("message.orderError"));
        }
        page = URLManager.getProperty("path.page.user.cart");
        return page;
    }

    private Order createOrderEntity( Long userId, int totalAmountOfOrder, String descr){
        Order order = null;
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        order = Order.builder().idOfCustomer(userId).dateOfOrder(dateNow).timeOfOrder(timeNow)
                .totalAmountOrder(totalAmountOfOrder).orderStatus(OrderStatus.IS_CONFIRMED).orderDescription(descr).paymentDescription(
                        PaymentDescription.builder()
                                .build()
                ).build();
        return order;
    }

    public void addOrderToDataBase(Order order){
        try {
            new OrderDAOImpl().create(order);
        } catch (SQLException e) {
            LOG.error("SQLException in method execute");
        }
    }

    public void changeDescriptionOfOrder(String orderDescription, HashMap<Item, Integer> cart ){
        for (Map.Entry <Item, Integer> entry : cart.entrySet()){
            orderDescription = orderDescription.concat(entry.getKey().getModel()).concat(" ");
        }
    }
}
