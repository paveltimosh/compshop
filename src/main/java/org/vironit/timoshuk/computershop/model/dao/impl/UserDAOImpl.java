package org.vironit.timoshuk.computershop.model.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.vironit.timoshuk.computershop.model.dao.DAOException;
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
    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String SQL_INSERT_INTO_USERS = "INSERT INTO users  " +
        "( login, password, address, email, first_name, last_name, id_card, user_type, phone_number )VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String SQL_UPDATE_USER_INFO = "UPDATE users SET first_name=?, last_name=?, address =?, email=?, phone_number=? WHERE id=?";
    private static final String SQL_UPDATE_USER_PASSWORD_BY_ID = "UPDATE users SET password=? WHERE id = ?";


    @Override
    public List<User> findAll() throws DAOException {
        List<User> customers = new ArrayList<>();
        try(Connection conn = DataBasePoolConnector.getConnection();
            PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_ALL_USERS);
            ResultSet rs = prepStat.executeQuery()) {
                while (rs.next()){
                    User user = new User();
                    setUserAllFields(user, rs);
                    customers.add(user);
                }
        } catch (SQLException e) {
            LOG.error("SQL exeprion (request or table failed) in method findAll() ", e);
            throw new DAOException("SQL Exception ",e);
        }
        return customers;
    }

    @Override
    public User findUserById(Long id) throws DAOException {
        User user = new User();
        try (Connection conn = DataBasePoolConnector.getConnection();
        PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_USER_BY_ID);) {
            prepStat.setLong(1, id);
            ResultSet rs = prepStat.executeQuery();
            rs.next();
            setUserAllFields(user, rs);

        } catch (SQLException e) {
            LOG.error("SQL exeprion (request or table failed)in method findUserById(Long id) ", e);
            throw new DAOException("SQL Exception ",e);
        }
        return user;
    }

    @Override
    public boolean deleteUserById(Long id) throws DAOException {
        boolean result = false;
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_DELETE_USER_BY_ID)) {
            prepStat.setLong(1, id);
            prepStat.executeUpdate();
            result = true;
        } catch (SQLException e) {
            LOG.error("SQL exeprion (request or table failed) in method deleteUserById ", e);
            throw new DAOException("SQL Exception ",e);
        }
        return result;
    }

    @Override
    public boolean deleteUser(User user) throws DAOException {
        return deleteUserById(user.getId());
    }

    @Override
    public boolean createUser(User user) throws DAOException {
        boolean result = false;
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_INSERT_INTO_USERS)) {
            prepStat.setString(1, user.getLogin());
            prepStat.setString(2, user.getPassword());
            prepStat.setString(3, user.getAddress());
            prepStat.setString(4, user.getEmail());
            prepStat.setString(5, user.getFirstName());
            prepStat.setString(6, user.getLastName());
            prepStat.setInt(7, user.getIdCard());
            prepStat.setString(8, user.getUserType().toString());
            prepStat.setString(9, user.getPhoneNumber());
            prepStat.executeUpdate();
            result = true;
        } catch (SQLException e) {

            LOG.error("SQL exeprion (request or table failed) in method createUser ()", e);
            throw new DAOException("SQL Exception ",e);
        }
        return result;
    }
    
    @Override
    public boolean update(User user, Long id) throws DAOException {
        boolean result = false;
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_UPDATE_USER_INFO)) {
            prepStat.setLong(6,id);
            prepStat.setString(1, user.getFirstName());
            prepStat.setString(2, user.getLastName());
            prepStat.setString(3,user.getAddress());
            prepStat.setString(4,user.getEmail());
            prepStat.setString(5, user.getPhoneNumber());
            prepStat.executeUpdate();
            result = true;
        }catch (SQLException e){
            LOG.info("SQL exeprion (request or table failed) in method update(User user)", e);
            throw new DAOException("SQL Exception ",e);
        }
        return result;
    }

    public User findUserByLogin (String login) throws DAOException {
        User user = new User();
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_SELECT_USER_BY_LOGIN);) {
            prepStat.setString(1, login);
            ResultSet rs = prepStat.executeQuery();
            rs.next();
            setUserAllFields(user, rs);
        } catch (SQLException e) {
            LOG.error("SQL exeprion (request or table failed)in method findUserByLogin (String login) ", e);
            throw new DAOException("SQL Exception ",e);
        }
        return user;
    }

    public boolean updateUserPasswordById (String newPassword, Long id) throws DAOException {
        boolean result = false;
        try (Connection conn = DataBasePoolConnector.getConnection();
             PreparedStatement prepStat = conn.prepareStatement(SQL_UPDATE_USER_PASSWORD_BY_ID);) {
            prepStat.setLong(2, id);
            prepStat.setString(1, newPassword);
            prepStat.executeUpdate();
            result = true;
        }catch (SQLException e){
            LOG.error("SQL exeprion (request or table failed)in method updateUserPasswordById ", e);
            throw new DAOException("SQL Exception ",e);
        }
        return result;
    }

    private void setUserAllFields(User user, ResultSet rs) throws SQLException {
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
    }

}
