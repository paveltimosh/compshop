package org.vironit.timoshuk.computershop.command.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.command.ActionCommand;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.entity.order.PaymentDescription;
import org.vironit.timoshuk.computershop.entity.order.TypePayment;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.resource.MessageManager;
import org.vironit.timoshuk.computershop.resource.URLManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ConfirmOrderCommand implements ActionCommand {

    private static final String PARAM_NAME_ORDER_ID = "orderId";
    private static final String PARAM_NAME_PAYMENT_TYPE = "paymentType";

    private static final Logger LOG = LogManager.getLogger(ConfirmOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        boolean result = false;
        Long orderId = Long.valueOf(request.getParameter(PARAM_NAME_ORDER_ID ));
        String paymentType = request.getParameter(PARAM_NAME_PAYMENT_TYPE);
        User user =(User) request.getSession().getAttribute("user");
        int ownMoney = user.getOwnMoney();

        try {
            OrderDAOImpl orderDAO = new OrderDAOImpl();
            Order order = orderDAO.findById(orderId);
            if(paymentType.equals(TypePayment.BANK_CARD.toString())){
                if (ownMoney >= order.getTotalAmountOrder()){
                    Order confirmedOrder = changePaymentDescrOfOrder(order, paymentType);
                    user.setOwnMoney(ownMoney - order.getTotalAmountOrder());
                    new UserDAOImpl().update(user);
                    result = true;
                }else {
                    result = false;
                }
            }else {
                Order confirmedOrder = changePaymentDescrOfOrder(order, paymentType);
                result = true;
            }
            orderDAO.update(order);
        } catch (SQLException e) {
            LOG.error("SQLException in method execute");
        }
        if(result){
            request.setAttribute("orderConfirmSuc", MessageManager.getProperty("message.orderConfirmSuccessful"));
        }else {
            request.setAttribute("orderConfirmError", MessageManager.getProperty("message.orderConfirmError"));
        }
        page = new ShowOrderUserCommand().execute(request);
        return page;
    }

    public Order changePaymentDescrOfOrder(Order order, String paymentType){
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        order.setOrderStatus(OrderStatus.IS_PAYED);
        order.setPaymentDescription(PaymentDescription.builder()
                .typePayment(TypePayment.valueOf(paymentType))
                .dateOfPayment(dateNow)
                .timeOfPayment(timeNow)
                .build());
        return order;
    }

}
