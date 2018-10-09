package org.vironit.timoshuk.computershop.model.dao.impl;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.vironit.timoshuk.computershop.model.dao.UserDAO;
import org.vironit.timoshuk.computershop.model.entity.users.User;
import org.vironit.timoshuk.computershop.model.entity.users.UserType;
import org.vironit.timoshuk.computershop.model.util.DataBasePoolConnector;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UserDAOImpl implements UserDAO<Long, User> {

    static private final Logger LOG = LogManager.getLogger(UserDAOImpl.class);

    private static final String SQL_SELECT_ALL_USERS = " SELECT * FROM users ";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String SQL_INSERT_INTO_USERS = "INSERT INTO users  " +
        "(id, login, password, address, email, first_name, last_name, id_card, user_type, phone_number )VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_SELECT_User_BY_LOGIN = "SELECT * FROM customers WHERE login = ?";

    @Override
    public List<User> findAll() {
        List<User> customers = new ArrayList<>();
        try(Connection conn = DataBasePoolConnector.getConnection();
            PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_ALL_USERS);
            ResultSet rs = prepStat.executeQuery()) {
                while (rs.next()){
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setAddress(rs.getString("address"));
                    user.setEmail(rs.getString("email"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setIdCard(rs.getInt("id_card"));
                    user.setUserType(UserType.valueOf(rs.getString("user_type")));
                    user.setPhoneNumber(rs.getString("phone_number"));
                    LOG.info("все нормас");
                    customers.add(user);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public User findUserById(Long id) {
        User user = new User();
        try (Connection conn = DataBasePoolConnector.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_USER_BY_ID);) {
            prepStat.setLong(1, id);
            ResultSet rs = prepStat.executeQuery();
            rs.next();
            user.setId(rs.getLong("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setAddress(rs.getString("address"));
            user.setEmail(rs.getString("email"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setIdCard(rs.getInt("id_card"));
            user.setUserType(UserType.valueOf(rs.getString("user_type")));
            user.setPhoneNumber(rs.getString("phone_number"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteUserById(Long id) {
        boolean result = false;
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_DELETE_USER_BY_ID)) {
            prepStat.setLong(1, id);
            prepStat.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteUser(User user) {
        return deleteUserById(user.getId());
    }

    @Override
    public boolean createUser(User customer) {
        boolean result = false;
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_INSERT_INTO_USERS)) {
            prepStat.setLong(1, customer.getId());
            prepStat.setString(2, customer.getLogin());
            prepStat.setString(3, customer.getPassword());
            prepStat.setString(4, customer.getAddress());
            prepStat.setString(5, customer.getEmail());
            prepStat.setString(6, customer.getFirstName());
            prepStat.setString(7, customer.getLastName());
            prepStat.setInt(8, customer.getIdCard());
            prepStat

            prepStat.executeUpdate();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(User customer) {
        return false;
    }

}
