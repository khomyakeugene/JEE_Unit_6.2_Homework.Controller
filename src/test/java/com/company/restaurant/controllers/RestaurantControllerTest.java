package com.company.restaurant.controllers;

import com.company.restaurant.model.Course;
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
    private static final int COURSE_CATEGORY_ID = 1;

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

        // Check delete of non-existent data
        restaurantController.delEmployee(employee);
        // Select test <employee> and check that in does not exist
        employeeById = restaurantController.findEmployeeById(employeeId);
        assertTrue(employeeById == null);
    }

    @Test
    public void addFindDelCourseTest() throws Exception {
        // Generate test <course>
        String name = Util.getRandomString();
        Course course = new Course(0, COURSE_CATEGORY_ID, name, Util.getRandomFloat(), Util.getRandomFloat());

        restaurantController.addCourse(course);

        Course courseByName = restaurantController.findCourseByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(course, courseByName));

        restaurantController.delCourse(name);
        courseByName = restaurantController.findCourseByName(name);
        assertTrue(courseByName == null);

        // Test delete by "the whole object"
        restaurantController.addCourse(course);
        courseByName = restaurantController.findCourseByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(course, courseByName));
        restaurantController.delCourse(course);
        courseByName = restaurantController.findCourseByName(name);
        assertTrue(courseByName == null);
    }
}