package org.vironit.timoshuk.computershop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.users.User;
import org.vironit.timoshuk.computershop.hibernateDAO.impl.OrderDAOImpl;
import org.vironit.timoshuk.computershop.util.DataBasePoolConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main  {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            Connection connection =  DataBasePoolConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

