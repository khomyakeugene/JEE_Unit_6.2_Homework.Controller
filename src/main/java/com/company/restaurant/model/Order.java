package com.company.restaurant.model;

import java.util.Date;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class Order {
    private int orderId;
    private int tableId;
    private int employeeId;
    private char state_type;
    private String orderNumber;
    private Date orderDatetime;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public char getState_type() {
        return state_type;
    }

    public void setState_type(char state_type) {
        this.state_type = state_type;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }
}
