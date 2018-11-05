package org.vironit.timoshuk.computershop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.products.Computer;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.productDAO.ComputerDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class Main  {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            List<Order> orderList = new OrderDAOImpl().findAll();
            for (Order order : orderList) {
                System.out.println(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

