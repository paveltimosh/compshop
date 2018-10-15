package org.vironit.timoshuk.computershop;

import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.dao.impl.ComputerDAOImpl;
import org.vironit.timoshuk.computershop.model.dao.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.model.dao.impl.UserDAOImpl;
import org.vironit.timoshuk.computershop.model.entity.order.Order;
import org.vironit.timoshuk.computershop.model.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.model.entity.order.PaymentDescription;
import org.vironit.timoshuk.computershop.model.entity.order.TypePayment;
import org.vironit.timoshuk.computershop.model.entity.products.Computer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ComputerDAOImpl computerDAO = new ComputerDAOImpl();
        try {
            List <Computer> computers = new ArrayList<>();
            computers = computerDAO.findAll();
            for (Computer computer : computers) {
                System.out.println(computer);
            }

        } catch (DAOException e) {
            e.printStackTrace();
        }


    }

    void testOrder (){
        int[] customers = new int[55];
        int size = customers.length;

        UserDAOImpl userDAO = new UserDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        List <Order> orders = new ArrayList<>();
        Order order1 = Order.builder()
                .dateTimeOfOrder(LocalDateTime.now())
                .totalAmountOrder(546)
                .idOfCustomer(1L)
                .orderStatus(OrderStatus.IS_COMPLETED)
                .paymentDescription(PaymentDescription.builder()
                        .dateTimeOfPayment(LocalDateTime.now())
                        .typePayment(TypePayment.BANK_CARD)
                        .id(545854L)
                        .build())
                .build();

        try {
//            orderDAO.createOrder(order1);
            orders = orderDAO.findOrdersByDateOfOrder(LocalDate.now());
            for (Order order : orders) {
                System.out.println(order);
            }

        } catch (DAOException daoExсeption) {
            daoExсeption.printStackTrace();
        }
    }
}
