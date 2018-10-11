package org.vironit.timoshuk.computershop.model.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.model.dao.DAOException;
import org.vironit.timoshuk.computershop.model.dao.OrderDAO;
import org.vironit.timoshuk.computershop.model.entity.order.Order;
import org.vironit.timoshuk.computershop.model.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.model.entity.order.PaymentDescription;
import org.vironit.timoshuk.computershop.model.entity.order.TypePayment;
import org.vironit.timoshuk.computershop.model.util.DataBasePoolConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO <Long, Order>{

    private static final Logger LOG = LogManager.getLogger(OrderDAOImpl.class);

    private static final String SQL_SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String SQL_SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ?";
    private static final String SQL_DELETE_ORDER_BY_ID = "DELETE  FROM orders WHERE id = ? ";
    private static final String SQL_INSERT_INTO_ORDERS = "INSERT INTO orders " +
            "( id_of_customer, date_time_of_order, total_amount_of_order, order_status, id_of_payment, date_time_of_payment, payment_type)" +
            "VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_ORDER_BY_ID = "UPDATE orders " +
            "SET date_time_of_order =?, total_amount_of_order = ?, order_status = ?, date_time_of_payment = ?, payment_type = ?" +
            "WHERE id = ?";


    @Override
    public List<Order> findAll() throws DAOException {
        List <Order> orders = new ArrayList<>();
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_SELECT_ALL_ORDERS);
             ResultSet rs = prepStat.executeQuery()) {
            while (rs.next()){
                Order order = new Order();
                setOrderAllFields(order, rs);
                orders.add(order);
            }
        }catch (SQLException e){
            LOG.error("SQL exeprion (request or table failed) in method findAll()", e);
            throw new DAOException("SQL Exception ",e);
        }
        return orders;
    }

    @Override
    public Order findOrderById(Long id) throws DAOException {
        Order order = new Order();
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_SELECT_ORDER_BY_ID)){
             prepStat.setLong(1, id);
             ResultSet rs = prepStat.executeQuery();
             rs.next();
             setOrderAllFields(order, rs);
        } catch (SQLException e) {
            LOG.error("SQL exeprion (request or table failed) in method findOrderById", e);
            throw new DAOException("SQL Exception ",e);
        }
        return order;
    }

    @Override
    public boolean deleteOrderById(Long id) throws DAOException {
        boolean result = false;
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_DELETE_ORDER_BY_ID)){
            prepStat.setLong(1, id);
            prepStat.executeUpdate();
            result = true;
        }catch (SQLException e){
            LOG.error("SQL exeprion (request or table failed) in method deleteOrder", e);
            throw new DAOException("SQL Exception ",e);
        }
        return result;
    }

    @Override
    public boolean createOrder(Order order) throws DAOException {
        boolean result = false;
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_INSERT_INTO_ORDERS)){
            prepStat.setLong(1, order.getIdOfCustomer());
            prepStat.setTimestamp(2, order.getDateTimeOfOrder());
            prepStat.setInt(3, order.getTotalAmountOrder());
            prepStat.setString(4, order.getOrderStatus().toString());
            prepStat.setLong(5, order.getPaymentDescription().getId());
            prepStat.setTimestamp(6, order.getPaymentDescription().getDateTimeOfPayment());
            prepStat.setString(7, order.getPaymentDescription().getTypePayment().toString());
            prepStat.executeUpdate();
            result = true;
        }catch (SQLException e){
            LOG.error("SQL exeprion (request or table failed) in method createOrder", e);
            throw new DAOException("SQL Exception ",e);
        }
        return result;
    }

    @Override
    public boolean update(Order order, Long id) throws DAOException {
        boolean result = false;
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_UPDATE_ORDER_BY_ID)){
            prepStat.setLong(6, id);
            prepStat.setTimestamp(1, order.getDateTimeOfOrder());
            prepStat.setInt(2, order.getTotalAmountOrder());
            prepStat.setString(3, order.getOrderStatus().toString());
            prepStat.setTimestamp(4, order.getPaymentDescription().getDateTimeOfPayment());
            prepStat.setString(5, order.getPaymentDescription().getTypePayment().toString());

            prepStat.executeUpdate();
        }catch (SQLException e){
            LOG.error("SQL exeprion (request or table failed) in method update", e);
            throw new DAOException("SQL Exception ",e);
        }
        return false;
    }


    private void setOrderAllFields(Order order, ResultSet rs) throws SQLException {
        order.setId(rs.getLong("id"));
        order.setIdOfCustomer(rs.getLong("id_of_customer"));
        order.setDateTimeOfOrder(rs.getTimestamp("date_time_of_order"));
        order.setTotalAmountOrder(rs.getInt("total_amount_of_order"));
        order.setOrderStatus(OrderStatus.valueOf(rs.getString("order_status")));
        order.setPaymentDescription(PaymentDescription.builder()
                .id(rs.getLong("id_of_payment"))
        .dateTimeOfPayment(rs.getTimestamp("date_time_of_payment"))
        .typePayment(TypePayment.valueOf(rs.getString("payment_type")))
        .build());
    }
}
