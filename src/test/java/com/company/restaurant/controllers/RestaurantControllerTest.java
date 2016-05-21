package com.company.restaurant.controllers;

import com.company.restaurant.model.*;
import com.company.util.ObjectService;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by Yevhen on 20.05.2016.
 */
public class RestaurantControllerTest {
    private static RestaurantController restaurantController;

    private int jobPositionId() {
        return restaurantController.findAllJobPositions().get(0).getId();
    }

    private int courseCategoryId() {
        return restaurantController.findAllCourseCategories().get(0).getId();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        restaurantController = RestaurantController.getInstance();
    }

    @Test
    public void addFindDelJobPosition() throws Exception {
        String name = Util.getRandomString();
        JobPosition jobPosition = restaurantController.addJobPosition(name);

        JobPosition jobPositionByName = restaurantController.findJobPositionByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(jobPosition, jobPositionByName));

        restaurantController.delJobPosition(name);
        assertTrue(restaurantController.findJobPositionByName(name) == null);
        // Test delete of non-existent data
        restaurantController.delJobPosition(name);
    }

    @Test
    public void addFindDelEmployeeTest() throws Exception {
        String firstName = Util.getRandomString();
        String secondName = Util.getRandomString();
        String phoneNumber = Util.getRandomString();
        float salary = Util.getRandomFloat();
        Employee employee = new Employee(0, jobPositionId(), firstName, secondName, phoneNumber, salary);
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

        restaurantController.delEmployee(employee);
        assertTrue(restaurantController.findEmployeeById(employeeId) == null);
        // Test delete of non-existent data
        restaurantController.delEmployee(employee);
    }

    @Test
    public void addFindDelCourseCategoryTest() throws Exception {
        String name = Util.getRandomString();
        CourseCategory courseCategory = restaurantController.addCourseCategory(name);

        CourseCategory courseCategoryByName = restaurantController.findCourseCategoryByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(courseCategory, courseCategoryByName));

        restaurantController.delCourseCategory(name);
        assertTrue(restaurantController.findCourseCategoryByName(name) == null);
        // Test delete of non-existent data
        restaurantController.delCourseCategory(name);
    }

    @Test
    public void addFindDelCourseTest() throws Exception {
        String name = Util.getRandomString();
        Course course = new Course(0, courseCategoryId(), name, Util.getRandomFloat(), Util.getRandomFloat());
        restaurantController.addCourse(course);

        Course courseByName = restaurantController.findCourseByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(course, courseByName));

        restaurantController.delCourse(name);
        assertTrue(restaurantController.findCourseByName(name) == null);
        // Test delete by "the whole object"
        restaurantController.addCourse(course);
        courseByName = restaurantController.findCourseByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(course, courseByName));
        restaurantController.delCourse(course);
        assertTrue(restaurantController.findCourseByName(name) == null);
        // Test delete of non-existent data
        restaurantController.delCourse(name);
    }

    @Test
    public void addFindDelMenuTest() throws Exception {
        String name = Util.getRandomString();
        Menu menu = restaurantController.addMenu(name);

        Menu menuByName = restaurantController.findMenuByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(menu, menuByName));

        restaurantController.delMenu(name);
        assertTrue(restaurantController.findMenuByName(name) == null);
        // Test delete of non-existent data
        restaurantController.delMenu(name);
    }
}