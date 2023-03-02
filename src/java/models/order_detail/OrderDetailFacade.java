package models.order_detail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.DBContext;

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
        public static ArrayList<OrderDetail> getOrderDetail(int orderId) throws Exception {
        ArrayList<OrderDetail> list = new ArrayList<>();
        Connection cn = DBContext.getConnection();
        if (cn != null) {
            String sql = "select order_id,product_id,quantity\n"
                    + "from order_details\n"
                    + "where order_id=? ";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, orderId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                OrderDetail orderDetail = new OrderDetail(orderId, productId, quantity);
                list.add(orderDetail);
            }
            cn.close();
        }
        return list;
    }
}
