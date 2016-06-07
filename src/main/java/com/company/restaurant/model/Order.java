package com.company.restaurant.model;

import java.sql.Timestamp;

/**
 * Created by Yevhen on 22.05.2016.
 */
public class Order {
    private int orderId;
    private int tableId;
    private int employeeId;
    private String stateType;
    private String orderNumber;
    private Timestamp orderDatetime;
    private String stateTypeName;
    private int employeeJobPositionId;
    private String employeeFirstName;
    private String employeeSecondName;
    private String employeePhoneNumber;
    private Float employeeSalary;
    private String employeeJobPositionName;
    private int tableNumber;
    private String tableDescription;


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

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String  stateType) {
        this.stateType = stateType;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Timestamp getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Timestamp orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getStateTypeName() {
        return stateTypeName;
    }

    public void setStateTypeName(String stateTypeName) {
        this.stateTypeName = stateTypeName;
    }

    public int getEmployeeJobPositionId() {
        return employeeJobPositionId;
    }

    public void setEmployeeJobPositionId(int employeeJobPositionId) {
        this.employeeJobPositionId = employeeJobPositionId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeSecondName() {
        return employeeSecondName;
    }

    public void setEmployeeSecondName(String employeeSecondName) {
        this.employeeSecondName = employeeSecondName;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public Float getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeJobPositionName() {
        return employeeJobPositionName;
    }

    public void setEmployeeJobPositionName(String employeeJobPositionName) {
        this.employeeJobPositionName = employeeJobPositionName;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getTableDescription() {
        return tableDescription;
    }

    public void setTableDescription(String tableDescription) {
        this.tableDescription = tableDescription;
    }
}
