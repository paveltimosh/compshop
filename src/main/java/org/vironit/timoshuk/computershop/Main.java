package org.vironit.timoshuk.computershop;

import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.dao.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.model.dao.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.model.entity.order.Order;
import org.vironit.timoshuk.computershop.model.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.model.entity.order.PaymentDescription;
import org.vironit.timoshuk.computershop.model.entity.order.TypePayment;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        List <Order> orders = new ArrayList<>();
        Order order1 = Order.builder()
                .dateTimeOfOrder(Timestamp.valueOf(LocalDateTime.now()))
                .totalAmountOrder(546)
                .idOfCustomer(1L)
                .orderStatus(OrderStatus.IS_COMPLETED)
                .paymentDescription(PaymentDescription.builder()
                        .dateTimeOfPayment(Timestamp.valueOf(LocalDateTime.now()))
                        .typePayment(TypePayment.BANK_CARD)
                        .id(222L)
                        .build())
                .build();

        try {
//            orderDAO.createOrder(order1);
            orders = orderDAO.findAll();
            for (Order order : orders) {
                System.out.println(order);
            }

            LocalDateTime localDateTime = order1.getDateTimeOfOrder().toLocalDateTime();
            System.out.println(localDateTime);
        } catch (DAOException daoExсeption) {
            daoExсeption.printStackTrace();
        }


}
}
