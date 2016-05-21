package com.company.restaurant.controllers;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.CourseCategoryDic;
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

    private int courseCategoryId() {
        return restaurantController.findAllCourseCategories().get(0).getId();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        restaurantController = RestaurantController.getInstance();
    }

    @Test
    public void addFindDelEmployeeTest() throws Exception {
        String firstName = Util.getRandomString();
        String secondName = Util.getRandomString();
        String phoneNumber = Util.getRandomString();
        float salary = Util.getRandomFloat();
        Employee employee = new Employee(0, EMPLOYEE_POSITION_ID, firstName, secondName, phoneNumber, salary);
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
        employeeById = restaurantController.findEmployeeById(employeeId);
        assertTrue(employeeById == null);

        // Test delete of non-existent data
        restaurantController.delEmployee(employee);
    }

    @Test
    public void addFindDelCourseCategoryTest() throws Exception {
        String name = Util.getRandomString();
        CourseCategoryDic courseCategory = restaurantController.addCourseCategory(name);

        CourseCategoryDic courseCategoryByName = restaurantController.findCourseCategoryByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(courseCategory, courseCategoryByName));

        restaurantController.delCourseCategory(name);
        courseCategoryByName = restaurantController.findCourseCategoryByName(name);
        assertTrue(courseCategoryByName == null);

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
        courseByName = restaurantController.findCourseByName(name);
        assertTrue(courseByName == null);

        // Test delete by "the whole object"
        restaurantController.addCourse(course);
        courseByName = restaurantController.findCourseByName(name);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(course, courseByName));
        restaurantController.delCourse(course);
        courseByName = restaurantController.findCourseByName(name);
        assertTrue(courseByName == null);

        // Test delete of non-existent data
        restaurantController.delCourse(name);
    }
}