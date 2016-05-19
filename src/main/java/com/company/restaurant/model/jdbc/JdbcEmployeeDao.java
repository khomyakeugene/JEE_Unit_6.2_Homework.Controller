package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Employee;
import com.company.restaurant.model.EmployeeDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public class JdbcEmployeeDao extends JdbcDaoTable<Employee> implements EmployeeDao {
    private static final String EMPLOYEE_TABLE_NAME = "employee";
    private static final String EMPLOYEE_ID_FIELD_NAME = "employee_id";
    private static final String POSITION_ID_FIELD_NAME = "position_id";
    private static final String FIRST_NAME_FIELD_NAME = "first_name";
    private static final String SECOND_NAME_FIELD_NAME = "second_name";
    private static final String PHONE_NUMBER_FIELD_NAME = "phone_number";
    private static final String SALARY_FIELD_NAME = "salary";
    private static final String DEFAULT_ORDER_BY_CONDITION = "ORDER BY second_name, first_name";

    public JdbcEmployeeDao() {
        this.tableName = EMPLOYEE_TABLE_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    private Employee createEmployee(ResultSet resultSet) {
        Employee result = null;

        if (resultSet != null) {
            try {
                result = new Employee(resultSet.getInt(EMPLOYEE_ID_FIELD_NAME),
                        resultSet.getInt(POSITION_ID_FIELD_NAME), resultSet.getString(FIRST_NAME_FIELD_NAME),
                        resultSet.getString(SECOND_NAME_FIELD_NAME), resultSet.getString(PHONE_NUMBER_FIELD_NAME),
                        resultSet.getFloat(SALARY_FIELD_NAME));
            } catch (SQLException e) {
                databaseError(e);
            }
        }

        return result;
    }

    @Override
    protected Employee createObject(ResultSet resultSet) {
        return createEmployee(resultSet);
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
        return findObjectByFieldCondition(EMPLOYEE_ID_FIELD_NAME, employeeId);
    }

    @Override
    public List<Employee> findEmployeeByFirstName(String firstName) {
        return findObjectsByFieldCondition(FIRST_NAME_FIELD_NAME, firstName);
    }

    @Override
    public List<Employee> findEmployeeBySecondName(String secondName) {
        return findObjectsByFieldCondition(SECOND_NAME_FIELD_NAME, secondName);
    }

    @Override
    public List<Employee> findEmployeeByFirstAndSecondName(String firstName, String secondName) {
        return findObjectsByTwoFieldCondition(FIRST_NAME_FIELD_NAME, firstName, SECOND_NAME_FIELD_NAME, secondName);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return findAllObjects();
    }
}
