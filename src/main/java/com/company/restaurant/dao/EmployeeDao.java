package com.company.restaurant.dao;

import com.company.restaurant.model.Employee;

import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public interface EmployeeDao {
    Employee addEmployee(Employee employee);

    String delEmployee(Employee employee);

    String delEmployee(int employeeId);

    Employee findEmployeeById(int id);

    List<Employee> findEmployeeByFirstName(String firstName);

    List<Employee> findEmployeeBySecondName(String lastName);

    List<Employee> findEmployeeByFirstAndSecondName(String firstName, String secondName);

    List<Employee> findAllEmployees();

}
