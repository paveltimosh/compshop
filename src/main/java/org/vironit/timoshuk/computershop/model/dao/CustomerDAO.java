package org.vironit.timoshuk.computershop.model.dao;

import org.vironit.timoshuk.computershop.model.entity.users.Customer;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface CustomerDAO <Key , T extends Customer> {

    List <T> findAll();
    T findCostumerById (Key id);
    boolean deleteCustomer (T customer);
    boolean deleteCustomerById (Key id);
    boolean createCustomer (T customer);
    boolean update (T customer);

    default void closeStatement (Statement statement){
        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
