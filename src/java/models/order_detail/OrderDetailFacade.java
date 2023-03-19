package models.order_detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import models.DBContext;
import models.dashBoard.dashBoard;
import models.order.Order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daing
 */
public class OrderDetailFacade {

    public static ArrayList<OrderDetail> getOrderDetailsByOrderId(int orderId) throws Exception {
        ArrayList<OrderDetail> list = new ArrayList<>();

        Connection cn = DBContext.getConnection();
        if (cn != null) {
            String sql = "SELECT * FROM order_details where order_id";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int productId = rs.getInt("productId");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                OrderDetail orD = new OrderDetail(orderId, productId, quantity, price);
                list.add(orD);
            }
            cn.close();
        }
        return list;
    }

    public double getOrderTotalPrice(int orderId) throws SQLException {
        double total = 0;
        String sql = "SELECT SUM(price) as total FROM order_details WHERE order_id = ?";
        Connection cn = DBContext.getConnection();
        PreparedStatement st = cn.prepareStatement(sql);
        st.setInt(1, orderId);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            total = rs.getDouble("total");
        }
        cn.close();
        return total;
    }
}
