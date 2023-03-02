/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import models.DBContext;

/**
 *
 * @author daing
 */
public class OrderFacade {
    public static ArrayList<Order> getOrders() throws Exception {
        ArrayList<Order> list = new ArrayList<>();
        Connection cn = DBContext.getConnection();
        if(cn!=null){
            String sql="select id,order_date,delivery_date,status,address,account_id \n"
                    +"from oders \n";
            Statement statement= cn.createStatement();
            ResultSet rs= statement.executeQuery(sql);
            while(rs.next()){
                 int orderId = rs.getInt("id");
                Date orderDate = rs.getDate("order_date");
                Date deliverDate = rs.getDate("delivery_date");
                int status = rs.getInt("status");
                String address=rs.getString("address");
                int accId = rs.getInt("account_id");
                Order order = new Order(orderId, orderDate, deliverDate, status, address, accId);
                list.add(order);
            }
            cn.close();
            
        }
        return list;
    }
}
