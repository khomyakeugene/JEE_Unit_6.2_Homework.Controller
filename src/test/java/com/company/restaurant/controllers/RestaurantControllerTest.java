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

    private int employeeId() {
        return restaurantController.findAllEmployees().get(0).getEmployeeId();
    }

    private int tableId() {
        return restaurantController.findAllTables().get(0).getTableId();
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
        Employee employee = new Employee();
        employee.setJobPositionId(jobPositionId());
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        employee.setPhoneNumber(Util.getRandomString());
        employee.setSalary(Util.getRandomFloat());

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
        Course course = new Course();
        course.setCategoryId(courseCategoryId());
        course.setName(name);
        course.setWeight(Util.getRandomFloat());
        course.setCost(Util.getRandomFloat());
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

        // Courses in menu ----------------------------
        String courseName1 = Util.getRandomString();
        Course course1 = new Course();
        course1.setCategoryId(courseCategoryId());
        course1.setName(courseName1);
        course1.setWeight(Util.getRandomFloat());
        course1.setCost(Util.getRandomFloat());
        restaurantController.addCourse(course1);

        String courseName2 = Util.getRandomString();
        Course course2 = new Course();
        course2.setCategoryId(courseCategoryId());
        course2.setName(courseName2);
        course2.setWeight(Util.getRandomFloat());
        course2.setCost(Util.getRandomFloat());
        restaurantController.addCourse(course2);

        restaurantController.addCourseToMenu(menu, course1);
        restaurantController.addCourseToMenu(menu, course2);

        restaurantController.delCourseFromMenu(menu, course1);
        restaurantController.delCourseFromMenu(menu, course2);
        // ----------------------------

        restaurantController.delMenu(name);
        assertTrue(restaurantController.findMenuByName(name) == null);
        // Test delete of non-existent data
        restaurantController.delMenu(name);
    }

    @Test
    public void addFindDelTableTest() throws Exception {
        Table table = new Table();
        int number = Util.getRandomInteger();
        table.setNumber(number);
        table.setDescription(Util.getRandomString());
        restaurantController.addTable(table);

        Table tableByNumber = restaurantController.findTableByNumber(number);
        assertTrue(ObjectService.isEqualByGetterValuesStringRepresentation(table, tableByNumber));

        restaurantController.delTable(table);
        assertTrue(restaurantController.findTableByNumber(number) == null);
    }
}