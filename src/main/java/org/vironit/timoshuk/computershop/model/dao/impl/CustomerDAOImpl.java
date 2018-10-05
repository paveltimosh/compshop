package org.vironit.timoshuk.computershop.model.dao.impl;

import org.vironit.timoshuk.computershop.model.dao.CustomerDAO;
import org.vironit.timoshuk.computershop.model.entity.Busket;
import org.vironit.timoshuk.computershop.model.entity.users.Customer;
import org.vironit.timoshuk.computershop.model.util.DBPoolConnector;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO <Long, Customer> {


    private static final String SQL_SELECT_ALL_CUSTOMERS = " SELECT * FROM customers ";
    private static final String SQL_SELECT_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id = ?";
    private static final String SQL_DELETE_CUSTOMER_BY_ID = "DELETE FROM customers WHERE id = ?";
//TODO
   private static final String SQL_INSERT_INTO_CUSTOMER = "INSERT INTO customers  " +
        "(id, login, password, adress, email, firstname, lastName, idCard, OnBlackList )VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";


    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DBPoolConnector.getConnection();
            PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_ALL_CUSTOMERS);
            ResultSet rs = prepStat.executeQuery()) {
                while (rs.next()){
                    Customer customer = new Customer();
                    customer.setId(rs.getLong("id"));
                    customer.setLogin(rs.getString("login"));
                    customer.setPassword(rs.getString("password"));
                    customer.setAdress(rs.getString("adress"));
                    customer.setEmail(rs.getString("email"));
                    customer.setFirstName(rs.getString("firstname"));
                    customer.setLastName(rs.getString("lastname"));
                    customer.setIdCard(rs.getInt("idcard"));
                    customer.setOnBlackList(rs.getBoolean("onBlackList"));
                  //  customer.setBusket((Busket)rs.getObject("busket"));
                    customers.add(customer);
                }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findCostumerById(Long id) {
        Customer customer = new Customer();
        try (Connection conn = DBPoolConnector.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_CUSTOMER_BY_ID);) {
            prepStat.setLong(1, id);
            ResultSet rs = prepStat.executeQuery();
            rs.next();
            customer.setId(rs.getLong("id"));
            customer.setLogin(rs.getString("login"));
            customer.setPassword(rs.getString("password"));
            customer.setAdress(rs.getString("adress"));
            customer.setEmail(rs.getString("email"));
            customer.setFirstName(rs.getString("firstname"));
            customer.setLastName(rs.getString("lastname"));
            customer.setIdCard(rs.getInt("idcard"));
            customer.setOnBlackList(rs.getBoolean("onBlackList"));
            //  customer.setBusket((Busket)rs.getObject("busket"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean deleteCustomerById(Long id) {
        boolean result = false;
        try (Connection conn = DBPoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_DELETE_CUSTOMER_BY_ID)) {
            prepStat.setLong(1, id);
            prepStat.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return deleteCustomerById(customer.getId());
    }

    @Override
    public boolean createCustomer(Customer customer) {
        boolean result = false;
        try (Connection conn = DBPoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_INSERT_INTO_CUSTOMER)) {
            prepStat.setLong(1, customer.getId());
            prepStat.setString(2, customer.getLogin());
            prepStat.setString(3, customer.getPassword());
            prepStat.setString(4, customer.getAdress());
            prepStat.setString(5, customer.getEmail());
            prepStat.setString(6, customer.getFirstName());
            prepStat.setString(7, customer.getLastName());
            prepStat.setInt(8, customer.getIdCard());
            prepStat.setBoolean(9, customer.isOnBlackList());
            prepStat.executeUpdate();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

}
