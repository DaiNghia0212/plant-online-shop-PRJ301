package models.order_detail;

import java.sql.Connection;
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

    public static ArrayList<OrderDetail> getOrderDetail() throws Exception {
        ArrayList<OrderDetail> list = new ArrayList<>();

        Connection cn = DBContext.getConnection();
        if (cn != null) {
            String sql = "SELECT order_id,price" + "FROM order_details"
                    + "where order_id";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int orderId = rs.getInt("orderId");
                    int productId = rs.getInt("productId");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    OrderDetail orD = new OrderDetail(orderId, productId, quantity, price);
                    list.add(orD);
                }
            }
            cn.close();
        }
        return list;
    }

//    public static ArrayList<Order> getOrderByTime() throws SQLException {
//                ArrayList<Order> list = new ArrayList<>();
//
//        Connection cn = DBContext.getConnection();
//        if (cn != null) {
//            String sql = "SELECT id from orders WHERE order_date > ? AND order_date <? \n"
//                    + "SELECT SUM(price) from order_details where order_id = ? \n";
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            if(rs!=null){
//                while (rs.next()){
//                    int id=rs.getInt("id");
//                    Date orderDate=rs.getDate("orderDate");
//                    int status=rs.getInt("status");
//                    String address=rs.getString("address");
//                    int accId=rs.getInt("accId");
//                    Order order=new Order(id, (java.sql.Date) orderDate, status, address, accId);
//                    list.add(order);
//                }
//            }
//            cn.close();
//        }
//    return list;
//    }
    

}
