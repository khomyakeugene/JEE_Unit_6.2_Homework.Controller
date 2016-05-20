package com.company.restaurant.model.jdbc;

import com.company.restaurant.model.Employee;
import com.company.restaurant.model.EmployeeDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        this.idFieldName = EMPLOYEE_ID_FIELD_NAME;
        this.nameFieldName = SECOND_NAME_FIELD_NAME;
        this.orderByCondition = DEFAULT_ORDER_BY_CONDITION;
    }

    @Override
    protected Employee newObject(ResultSet resultSet) throws SQLException {
        return new Employee(resultSet.getInt(EMPLOYEE_ID_FIELD_NAME),
                resultSet.getInt(POSITION_ID_FIELD_NAME), resultSet.getString(FIRST_NAME_FIELD_NAME),
                resultSet.getString(SECOND_NAME_FIELD_NAME), resultSet.getString(PHONE_NUMBER_FIELD_NAME),
                resultSet.getFloat(SALARY_FIELD_NAME));
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

    @Override
    protected Map<String, Object> objectToDBMap(Employee employee) {
        HashMap<String, Object> result = new HashMap<>();

        result.put(POSITION_ID_FIELD_NAME, employee.getPositionId());
        result.put(FIRST_NAME_FIELD_NAME, employee.getFirstName());
        result.put(SECOND_NAME_FIELD_NAME, employee.getSecondName());
        result.put(PHONE_NUMBER_FIELD_NAME, employee.getPhoneNumber());
        result.put(SALARY_FIELD_NAME, employee.getSalary());

        return result;
    }

    @Override
    public int addEmployee(Employee employee) {
        return addRecord(employee);
    }

    @Override
    public void delEmployee(int employeeId) {

    }
}
