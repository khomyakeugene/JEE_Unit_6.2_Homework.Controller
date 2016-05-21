package com.company.restaurant.controllers;

import com.company.restaurant.model.Employee;
import com.company.util.ObjectService;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class RestaurantControllerTest {
    private static final int EMPLOYEE_POSITION_ID = 1;
    private static RestaurantController restaurantController;

    @BeforeClass
    public static void setUpClass() throws Exception {
        restaurantController = RestaurantController.getInstance();
    }

    @Test
    public void addFindDelEmployeeTest() throws Exception {
        // Generate test <employee>
        String firstName = Util.getRandomString();
        String secondName = Util.getRandomString();
        String phoneNumber = Util.getRandomString();
        float salary = Util.getRandomFloat();
        Employee employee = new Employee(0, EMPLOYEE_POSITION_ID, firstName, secondName, phoneNumber, salary);

        // Store test <employee>
        int employeeId = restaurantController.addEmployee(employee);

        // Select test <employee> and check
        Employee employeeByFirstName = restaurantController.findEmployeeByFirstName(firstName).get(0);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(employee, employeeByFirstName));

        Employee employeeBySecondName = restaurantController.findEmployeeBySecondName(secondName).get(0);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(employee, employeeBySecondName));

        Employee employeeByFirstAndSecondName =
                restaurantController.findEmployeeByFirstAndSecondName(firstName, secondName).get(0);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(employee, employeeByFirstAndSecondName));

        Employee employeeById = restaurantController.findEmployeeById(employeeId);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(employee, employeeById));

        // Delete test <employee>
        restaurantController.delEmployee(employee);
        // Select test <employee> and check that in does not exist
        employeeById = restaurantController.findEmployeeById(employeeId);
        assertTrue(employeeById == null);
    }
}