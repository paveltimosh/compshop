package org.vironit.timoshuk.computershop.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class  DataBasePoolConnector {

    private DataBasePoolConnector(){

    }

    private static HikariDataSource ds ;

    static {
        HikariConfig config = new HikariConfig("/hikari.properties");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}