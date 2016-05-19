package com.company.restaurant.model;

import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public interface EmployeeDao {
    int insertEmployee(int positionId, String firstName, String lastName, String phoneNumber, float salary);

    void deleteEmployee(int employeeId);

    Employee findEmployeeById(int employeeId);

    List<Employee> findEmployeeByFirstName(String firstName);

    List<Employee> findEmployeeByLastName(String lastName);

    List<Employee> findEmployeeByFirstAndLastName(String firstName, String lastName);

    List<Employee> findAllEmployees();

}
