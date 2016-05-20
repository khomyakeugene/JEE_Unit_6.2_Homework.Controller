package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public interface EmployeeDao {
    int insertEmployee(int positionId, String firstName, String secondName, String phoneNumber, float salary);

    void deleteEmployee(int employeeId);

    List<Employee> findEmployeeByFirstName(String firstName);

    List<Employee> findEmployeeBySecondName(String lastName);

    List<Employee> findEmployeeByFirstAndSecondName(String firstName, String secondName);

    List<Employee> findAllEmployees();

}
