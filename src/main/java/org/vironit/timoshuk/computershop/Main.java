package org.vironit.timoshuk.computershop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.vironit.timoshuk.computershop.util.DataBasePoolConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class Main  {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final org.slf4j.Logger LOG2 = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            Connection connection =  DataBasePoolConnector.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

