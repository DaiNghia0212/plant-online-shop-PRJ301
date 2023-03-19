/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import models.DBContext;
import models.cart.Cart;
import models.cart.Item;
import models.order_detail.OrderDetail;
import models.product.Product;

/**
 *
 * @author daing
 */
public class OrderFacade {

    private int insertOrderDetail(Connection con, OrderDetail orderDetail) throws SQLException {
        String sql = "INSERT into order_details VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStmt = con.prepareStatement(sql);
        preparedStmt.setInt(1, orderDetail.getOrderId());
        preparedStmt.setInt(2, orderDetail.getProductId());
        preparedStmt.setInt(3, orderDetail.getQuantity());
        preparedStmt.setDouble(4, orderDetail.getPrice());
        int affectedRows = preparedStmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating order failed, no rows affected.");
        }
        return affectedRows;
    }

    private int updateProductQuant(Connection con, Product product) throws SQLException {
        String sql = "UPDATE products SET quantity=?, updated_at = ? FROM products where id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(sql);
        preparedStmt.setInt(1, product.getQuantity());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        preparedStmt.setString(2, sdf.format(product.getUpdatedAt()));
        preparedStmt.setInt(3, product.getId());
        int affectedRows = preparedStmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating order failed, no rows affected.");
        }
        return affectedRows;
    }

    public void createOrder(Order order, Cart cart) throws Exception {
        Connection con = DBContext.getConnection();
        con.setAutoCommit(false);
        try {
            String sql = "INSERT into orders(status, address, account_id) VALUES(?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setInt(1, order.getStatus());
            preparedStmt.setString(2, order.getAddress());
            preparedStmt.setInt(3, order.getAccId());
            int affectedRows = preparedStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }
            ResultSet generatedKeys = preparedStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getInt(1));
            }
            Collection<Item> items = cart.getItems();
            for (Item item : items) {
                Product product = item.getProduct();
                OrderDetail orderDetail = new OrderDetail(order.getId(), product.getId(), item.getQuantity(), item.getCost());
                insertOrderDetail(con, orderDetail);
                product.setQuantity(product.getQuantity() - item.getQuantity());
                product.setUpdatedAt(new Date());
                updateProductQuant(con, product);
            }
            con.commit();
        } catch (Exception ex) {
            con.rollback();
            throw new Exception(ex.getMessage());
        }
        con.close();
    }

    public Map<String, Object> getOrders() throws SQLException {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    public Order getOrderById(int id) throws SQLException {
        Connection cn = DBContext.getConnection();
        Order order = null;
        String sql = "SELECT *\n"
                + "FROM order_details\n"
                + "WHERE id = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            Date orderDate = rs.getDate("orderDate");
            int status = rs.getInt("status");
            String address = rs.getString("address");
            int accId = rs.getInt("accId");
            order = new Order(id, orderDate, status, address, accId);
        }
        cn.close();
        return order;
    }

    public ArrayList<Order> getOrderByTime(Date start, Date end) throws SQLException {
        ArrayList<Order> list = new ArrayList<>();

        Connection cn = DBContext.getConnection();
        String sql = "SELECT * from orders WHERE order_date > ? AND order_date < ?";
        PreparedStatement st = cn.prepareStatement(sql);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        st.setString(1, sdf.format(start));
        st.setString(2, sdf.format(end));
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            Date orderDate = rs.getDate("orderDate");
            int status = rs.getInt("status");
            String address = rs.getString("address");
            int accId = rs.getInt("accId");
            Order order = new Order(id, orderDate, status, address, accId);
            list.add(order);
        }
        cn.close();
        return list;
    }
}
