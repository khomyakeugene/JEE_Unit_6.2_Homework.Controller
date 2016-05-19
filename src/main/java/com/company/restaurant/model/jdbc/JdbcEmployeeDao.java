package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Employee;
import com.company.restaurant.model.EmployeeDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public class JdbcEmployeeDao extends JdbcDao implements EmployeeDao {
    private static final String EMPLOYEE_TABLE_NAME = "employee";
    private static final String EMPLOYEE_ID_FIELD_NAME = "employee_id";
    private static final String POSITION_ID_FIELD_NAME = "position_id";
    private static final String FIRST_NAME_FIELD_NAME = "first_name";
    private static final String SECOND_NAME_FIELD_NAME = "second_name";
    private static final String PHONE_NUMBER_FIELD_NAME = "phone_number";
    private static final String SALARY_FIELD_NAME = "salary";

    public JdbcEmployeeDao() {
        this.tableName = EMPLOYEE_TABLE_NAME;
    }

    private Employee createEmployee(ResultSet resultSet)throws SQLException {
        return (resultSet == null) ? null : new Employee(resultSet.getInt(EMPLOYEE_ID_FIELD_NAME),
                resultSet.getInt(POSITION_ID_FIELD_NAME), resultSet.getString(FIRST_NAME_FIELD_NAME),
                resultSet.getString(SECOND_NAME_FIELD_NAME), resultSet.getString(PHONE_NUMBER_FIELD_NAME),
                resultSet.getFloat(SALARY_FIELD_NAME));
    }

    @Override
    public int insertEmployee(int positionId, String firstName, String secondName, String phoneNumber, float salary) {
        return 0;
    }

    @Override
    public void deleteEmployee(int employeeId) {

    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        return null;
    }

    @Override
    public List<Employee> findEmployeeByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Employee> findEmployeeByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Employee> findEmployeeByFirstAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return null;
    }
}
