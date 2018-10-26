package org.vironit.timoshuk.computershop.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vironit.timoshuk.computershop.dao.DAOException;
import org.vironit.timoshuk.computershop.dao.EntityDAOImpl;
import org.vironit.timoshuk.computershop.entity.order.Order;
import org.vironit.timoshuk.computershop.entity.order.OrderStatus;
import org.vironit.timoshuk.computershop.entity.order.PaymentDescription;
import org.vironit.timoshuk.computershop.entity.order.TypePayment;
import org.vironit.timoshuk.computershop.util.DataBasePoolConnector;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl extends EntityDAOImpl<Long, Order> {

    private static final Logger LOG = LogManager.getLogger(OrderDAOImpl.class);

    private static final String SQL_SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String SQL_SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ?";
    private static final String SQL_SELECT_ORDERS_BY_USER_ID = "SELECT * FROM orders WHERE id_of_customer = ?";
    private static final String SQL_SELECT_ORDERS_BY_ORDER_STATUS = "SELECT * FROM orders WHERE order_status = ?";
    private static final String SQL_SELECT_ORDERS_BY_DATE_OF_ORDER = "SELECT * FROM orders WHERE date_of_order = ?";
    private static final String SQL_DELETE_ORDER_BY_ID = "DELETE  FROM orders WHERE id = ? ";
    private static final String SQL_INSERT_INTO_ORDERS = "INSERT INTO orders " +
            "( id_of_customer, date_of_order, total_amount_of_order, order_status, id_of_payment, date_of_payment, payment_type, time_of_order, time_of_payment)" +
            "VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_ORDER_BY_ID = "UPDATE orders " +
            "SET date_of_order =?, total_amount_of_order = ?, order_status = ?, date_of_payment = ?, payment_type = ?, time_of_order =?,time_of_payment =?" +
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
            LOG.error("SQL exception (request or table failed) in method findAll()", e);
            throw new DAOException("SQL Exception ",e);
        }
        return orders;
    }

    @Override
    public Order findEntityById(Long id) throws DAOException {
        if (id <0){
            LOG.error("Illegal argument exception in method findOrderById, id = " + id);
            throw new IllegalArgumentException();
        }
        Order order = new Order();
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_SELECT_ORDER_BY_ID)){
             prepStat.setLong(1, id);
             ResultSet rs = prepStat.executeQuery();
             rs.next();
             setOrderAllFields(order, rs);
        } catch (SQLException e) {
            LOG.error("SQL Exception (request or table failed) in method findOrderById", e);
            throw new DAOException("SQL Exception ",e);
        }
        return order;
    }

    @Override
    public boolean deleteEntity(Order entity) throws DAOException {
        return deleteEntityById(entity.getId());
    }

    public List<Order> findEntityByUserId (Long userId) throws DAOException {
        if (userId <0){
            LOG.error("IllegalArgument exception for userId in method findOrdersByUserId, userId = " + userId);
            throw new IllegalArgumentException();
        }
        List <Order> orders = new ArrayList<>();
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_SELECT_ORDERS_BY_USER_ID)) {
            prepStat.setLong(1, userId);
            ResultSet rs = prepStat.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                setOrderAllFields(order, rs);
                orders.add(order);
            }
        }catch (SQLException e){
            LOG.error("SQL Exception (request or table failed) in method findOrderByUserId()", e);
            throw new DAOException("SQL Exception ",e);
        }
        return orders;
    }

    public List<Order> findOrdersByOrderStatus (OrderStatus orderStatus) throws DAOException {
        List <Order> orders = new ArrayList<>();
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_SELECT_ORDERS_BY_ORDER_STATUS)) {
            prepStat.setString(1, orderStatus.toString());
            ResultSet rs = prepStat.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                setOrderAllFields(order, rs);
                orders.add(order);
            }
        }catch (SQLException e){
            LOG.error("SQL Exception (request or table failed) in method findOrdersByOrderStatus", e);
            throw new DAOException("SQL Exception ",e);
        }
        return orders;
    }

    public List<Order> findOrdersByDateOfOrder (LocalDate localDate) throws DAOException {
        List <Order> orders = new ArrayList<>();
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_SELECT_ORDERS_BY_DATE_OF_ORDER)) {
            prepStat.setDate(1, Date.valueOf(localDate));
            ResultSet rs = prepStat.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                setOrderAllFields(order, rs);
                orders.add(order);
            }
        }catch (SQLException e){
            LOG.error("SQL Exception (request or table failed) in method findOrdersByDateOfOrder", e);
            throw new DAOException("SQL Exception ",e);
        }
        return orders;
    }

    @Override
    public boolean deleteEntityById(Long id) throws DAOException {
        if (id <=0){
            throw new NumberFormatException();
        }
        boolean result = false;
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_DELETE_ORDER_BY_ID)){
            prepStat.setLong(1, id);
            prepStat.executeUpdate();
            result = true;
        }catch (SQLException e){
            LOG.error("SQL Exception (request or table failed) in method deleteOrder", e);
            throw new DAOException("SQL Exception ",e);
        }
        return result;
    }

    @Override
    public boolean createEntity(Order order) throws DAOException {
        boolean result = false;
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_INSERT_INTO_ORDERS)){
            prepStat.setLong(1, order.getIdOfCustomer());
            prepStat.setDate(2, Date.valueOf(order.getDateTimeOfOrder().toLocalDate()));
            prepStat.setInt(3, order.getTotalAmountOrder());
            prepStat.setString(4, order.getOrderStatus().toString());
            prepStat.setLong(5, order.getPaymentDescription().getId());
            prepStat.setDate(6, Date.valueOf(order.getPaymentDescription().getDateTimeOfPayment().toLocalDate()));
            prepStat.setString(7, order.getPaymentDescription().getTypePayment().toString());
            prepStat.setTime(8, Time.valueOf(order.getDateTimeOfOrder().toLocalTime()) );
            prepStat.setTime(9, Time.valueOf(order.getPaymentDescription().getDateTimeOfPayment().toLocalTime()));
            prepStat.executeUpdate();
            result = true;
        }catch (SQLException e){
            LOG.error("SQL Exception (request or table failed) in method createOrder", e);
            throw new DAOException("SQL Exception ",e);
        }
        return result;
    }

    @Override
    public boolean update(Order order) throws DAOException {
        boolean result = false;
        try (Connection conn= DataBasePoolConnector.getConnection();
             PreparedStatement prepStat  = conn.prepareStatement(SQL_UPDATE_ORDER_BY_ID)){
            prepStat.setLong(8, order.getId());
            prepStat.setDate(1, Date.valueOf(order.getDateTimeOfOrder().toLocalDate()));
            prepStat.setInt(2, order.getTotalAmountOrder());
            prepStat.setString(3, order.getOrderStatus().toString());
            prepStat.setDate(4, Date.valueOf(order.getPaymentDescription().getDateTimeOfPayment().toLocalDate()));
            prepStat.setString(5, order.getPaymentDescription().getTypePayment().toString());
            prepStat.setTime(6,Time.valueOf(order.getDateTimeOfOrder().toLocalTime()) );
            prepStat.setTime(7, Time.valueOf(order.getPaymentDescription().getDateTimeOfPayment().toLocalTime()));
            prepStat.executeUpdate();
        }catch (SQLException e){
            LOG.error("SQL Exception (request or table failed) in method update", e);
            throw new DAOException("SQL Exception ",e);
        }
        return false;
    }

    private void setOrderAllFields(Order order, ResultSet rs) throws SQLException {
        order.setId(rs.getLong("id"));
        order.setIdOfCustomer(rs.getLong("id_of_customer"));
        order.setDateTimeOfOrder(LocalDateTime.of(rs.getDate("date_of_order").toLocalDate(), rs.getTime("time_of_order").toLocalTime()));
        order.setTotalAmountOrder(rs.getInt("total_amount_of_order"));
        order.setOrderStatus(OrderStatus.valueOf(rs.getString("order_status")));
        order.setPaymentDescription(PaymentDescription.builder()
                .id(rs.getLong("id_of_payment"))
        .dateTimeOfPayment(LocalDateTime.of(rs.getDate("date_of_payment").toLocalDate(), rs.getTime("time_of_payment").toLocalTime()))
        .typePayment(TypePayment.valueOf(rs.getString("payment_type")))
        .build());
    }
}
