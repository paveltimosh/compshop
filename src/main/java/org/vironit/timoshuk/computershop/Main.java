package org.vironit.timoshuk.computershop;


import org.vironit.timoshuk.computershop.model.dao.CustomerDAO;
import org.vironit.timoshuk.computershop.model.dao.impl.CustomerDAOImpl;
import org.vironit.timoshuk.computershop.model.entity.users.Customer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAOImpl();
        List <Customer> customers = new ArrayList<>();
        customers = customerDAO.findAll();
        System.out.println("Запрос на поиск всех сущностей выполнен" + customers);

        Customer customer = customerDAO.findCostumerById(1L);
        System.out.println("Запрос по поиску id выполнен" + customer);


    }
}
