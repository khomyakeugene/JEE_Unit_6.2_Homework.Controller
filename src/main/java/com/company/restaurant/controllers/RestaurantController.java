package com.company.restaurant.controllers;

import com.company.restaurant.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

/**
 * Created by Yevhen on 19.05.2016.
 */
public class RestaurantController {
    private final static String APPLICATION_CONTEXT_NAME = "application-context.xml";

    private PlatformTransactionManager txManager;
    private EmployeeDao employeeDao;
    private CourseDao courseDao;
    private MenuDao menuDao;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public static RestaurantController getInstance() {
        ApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_NAME);
        return context.getBean(RestaurantController.class);
    }

    public int addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);
    }

    public void delEmployee(Employee employee) {
        employeeDao.delEmployee(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    public List<Employee> findEmployeeByFirstName(String firstName) {
        return employeeDao.findEmployeeByFirstName(firstName);
    }

    public List<Employee> findEmployeeBySecondName(String lastName) {
        return employeeDao.findEmployeeBySecondName(lastName);
    }

    public List<Employee> findEmployeeByFirstAndSecondName(String firstName, String secondName) {
        return employeeDao.findEmployeeByFirstAndSecondName(firstName, secondName);
    }

    public Employee findEmployeeById(int id) {
        return employeeDao.findEmployeeById(id);
    }

    public int addCourse(Course course) {
       return courseDao.addCourse(course);
    }

    public void delCourse(Course course) {
        courseDao.delCourse(course);
    }

    public void delCourse(String name) {
        courseDao.delCourse(name);
    }

    public Course findCourseByName(String name) {
        return courseDao.findCourseByName(name);
    }

    public List<Course> findAllCourses() {
        return courseDao.findAllCourses();
    }

    public int addMenu(Menu menu) {
        return menuDao.addMenu(menu);
    }

    public void delMenu(Menu menu) {
        menuDao.delMenu(menu);
    }

    public void delMenu(String name) {
        menuDao.delMenu(name);
    }

    public Menu findMenuByName(String name) {
        return menuDao.findMenuByName(name);
    }

    public List<Menu> findAllMenus() {
        return menuDao.findAllMenus();
    }

    public int addCourseToMenu(String menuName, Course course) {
        return menuDao.addCourseToMenu(menuName, course);
    }

    public void delCourseFromMenu(String menuName, Course course) {
        menuDao.delCourseFromMenu(menuName, course);
    }
}
