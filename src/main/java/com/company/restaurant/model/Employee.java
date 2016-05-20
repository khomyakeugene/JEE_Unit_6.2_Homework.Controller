package com.company.restaurant.model;

/**
 * Created by Yevhen on 19.05.2016.
 */
public class Employee {
    private int employeeId;
    private int positionId;
    private String firstName;
    private String secondName;
    private String phoneNumber;
    private float salary;

    public Employee() {
    }

    public Employee(int employeeId, int positionId, String firstName, String secondName, String phoneNumber, float salary) {
        this.employeeId = employeeId;
        this.positionId = positionId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
