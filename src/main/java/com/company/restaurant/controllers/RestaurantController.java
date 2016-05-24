package com.company.restaurant.controllers;

import com.company.restaurant.model.*;
import javafx.scene.control.Tab;
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
    private JobPositionDao jobPositionDao;
    private EmployeeDao employeeDao;
    private CourseCategoryDao courseCategoryDao;
    private CourseDao courseDao;
    private MenuDao menuDao;
    private TableDao tableDao;
    private OrderAdapter orderAdapter;
    private KitchenAdapter kitchenAdapter;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setJobPositionDao(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setCourseCategoryDao(CourseCategoryDao courseCategoryDao) {
        this.courseCategoryDao = courseCategoryDao;
    }

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    public void setTableDao(TableDao tableDao) {
        this.tableDao = tableDao;
    }

    public void setOrderAdapter(OrderAdapter orderAdapter) {
        this.orderAdapter = orderAdapter;
    }

    public void setKitchenAdapter(KitchenAdapter kitchenAdapter) {
        this.kitchenAdapter = kitchenAdapter;
    }

    public OrderAdapter getOrderAdapter() {
        return orderAdapter;
    }

    public static RestaurantController getInstance() {
        ApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_NAME);
        return context.getBean(RestaurantController.class);
    }

    public JobPosition addJobPosition(String name) {
        return jobPositionDao.addJobPosition(name);
    }

    public void delJobPosition(String name) {
       jobPositionDao.delJobPosition(name);
    }

    public JobPosition findJobPositionByName(String name) {
        return jobPositionDao.findJobPositionByName(name);
    }

    public List<JobPosition> findAllJobPositions() {
        return jobPositionDao.findAllJobPositions();
    }

    public Employee addEmployee(Employee employee) {
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

    public CourseCategory addCourseCategory(String name) {
        return courseCategoryDao.addCourseCategory(name);
    }

    public void delCourseCategory(String name) {
        courseCategoryDao.delCourseCategory(name);
    }

    public CourseCategory findCourseCategoryByName(String name) {
        return courseCategoryDao.findCourseCategoryByName(name);
    }

    public List<CourseCategory> findAllCourseCategories() {
        return courseCategoryDao.findAllCourseCategories();
    }

    public Course addCourse(Course course) {
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

    public Menu addMenu(String name) {
        return menuDao.addMenu(name);
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

    public void addCourseToMenu(Menu menu, Course course) {
        menuDao.addCourseToMenu(menu, course);
    }

    public void delCourseFromMenu(Menu menu, Course course) {
        menuDao.delCourseFromMenu(menu, course);
    }

    Table addTable(Table table){
        return tableDao.addTable(table);
    }

    void delTable(Table table){
        tableDao.delTable(table);
    }

    Table findTableByNumber(int number){
        return tableDao.findTableByNumber(number);
    }

    List<Table> findAllTables(){
        return tableDao.findAllTables();
    }

    Order addOrder(Order order) {
        return orderAdapter.addOrder(order);
    }

    void delOrder(Order order) {
        orderAdapter.delOrder(order);
    }

    Order findOrderById(int id) {
        return orderAdapter.findOrderById(id);
    }

    Order closeOrder(Order order) {
        return orderAdapter.closeOrder(order);
    }

    List<Order> findAllOrders(String stateType) {
        return orderAdapter.findAllOrders(stateType);
    }

    List<Order> findAllOpenOrders() {
        return orderAdapter.findAllOpenOrders();
    }

    List<Order> findAllClosedOrders() {
        return orderAdapter.findAllClosedOrders();
    }

    void addCourseToOrder(Order order, Course course, int quantity) {
        orderAdapter.addCourseToOrder(order, course, quantity);
    }

    void takeCourseFromOrder(Order order, Course course, int quantity) {
        orderAdapter.takeCourseFromOrder(order, course, quantity);
    }

    void takeCourseFromOrder(Order order, Course course) {
        orderAdapter.takeCourseFromOrder(order, course);
    }

    public List<OrderCourse> findAllOrderCourses(Order order) {
        return orderAdapter.findAllOrderCourses(order);
    }

    void addCookedCourse(Course course, Employee employee, float weight) {
        kitchenAdapter.addCookedCourse(course, employee, weight);
    }

    List<CookedCourse> findAllCookedCourses() {
        return kitchenAdapter.findAllCookedCourses();
    }
}
