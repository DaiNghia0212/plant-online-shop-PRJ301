/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.order;

import java.sql.Date;

/**
 *
 * @author daing
 */
public class Order {
    private int orderId;
    private Date orderDate;
    private Date deliverDate;
    private int status;
    private String address;
    private int accId;

    public Order() {
    }

    
    public Order(int orderId, Date orderDate, Date deliverDate, int status, String address, int accId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.deliverDate = deliverDate;
        this.status = status;
        this.address = address;
        this.accId = accId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }
    
            
    
}
