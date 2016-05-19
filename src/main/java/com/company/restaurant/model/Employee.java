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
}
