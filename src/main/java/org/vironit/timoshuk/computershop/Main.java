package org.vironit.timoshuk.computershop;

import org.vironit.timoshuk.computershop.model.entity.Users.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/computershoptest", "postgres", "kapusta148");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            List <Customer> customers = new ArrayList<>();
            while (rs.next()){

                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setLogin(rs.getString("login"));
                customer.setPassword(rs.getString("password"));
                customers.add(customer);

            }
            System.out.println(customers.get(0));
            //stmt.executeQuery("INSERT INTO customers (login, password) VALUES ('pasha', 'timoshuk')");
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
